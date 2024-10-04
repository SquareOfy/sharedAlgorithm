def move_arduino():
    for idx, r, c in arduino_lst:
        if idx == -1: continue
        mn_dist = abs(r - ir) + abs(c - ic)
        mnr, mnc = -1, -1
        for ddi, ddj in DIR:
            nr, nc = r + ddi, c + ddj
            if nr < 0 or nc < 0 or nr >= R or nc >= C:
                continue
            nxt_dist = abs(nr - ir) + abs(nc - ic)
            if mn_dist > nxt_dist:
                mnr, mnc = nr, nc
                mn_dist = nxt_dist
        if mnr == ir and mnc == ic:
            return False
        tmp[mnr][mnc].append(idx)
        arduino_lst[idx] = (idx, mnr, mnc)

    for i in range(R):
        for j in range(C):
            if len(tmp[i][j]) >= 2:
                for idx in tmp[i][j]:
                    arduino_lst[idx] = (-1, -1, -1)
                tmp[i][j] = []
    for i in range(R):
        for j in range(C):
            arduino_arr[i][j] = tmp[i][j][:]
    return True


R, C = map(int, input().split())
arr = [list(input()) for _ in range(R)]
arduino_arr = [[[] for _ in range(C)] for _ in range(R)]
arduino_lst = []
idx = 0
DIR_I = (-1,), (1, -1), (1, 0), (1, 1), (0, -1), (0, 0), (0, 1), (-1, -1), (-1, 0), (-1, 1)
DIR = (1, -1), (1, 0), (1, 1), (0, -1), (0, 1), (-1, -1), (-1, 0), (-1, 1)
for i in range(R):
    for j in range(C):
        if arr[i][j] == 'I':
            ir, ic = i, j
        elif arr[i][j] == 'R':
            arduino_arr[i][j].append(idx)
            arduino_lst.append((idx, i, j))
            idx += 1

move_lst = list(map(int, list(input())))
# print(arduino_lst)
turn = 0
for m in move_lst:
    turn += 1

    di, dj = DIR_I[m]
    ir, ic = ir + di, ic + dj

    if arduino_arr[ir][ic]:
        break

    tmp = [[[] for _ in range(C)] for _ in range(R)]

    if not move_arduino():
        break

if turn == len(move_lst):
    result = [['.'] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if ir == i and ic == j:
                result[i][j] = 'I'
            elif arduino_arr[i][j]:
                result[i][j] = 'R'
        print(*result[i], sep='')
else:
    print("kraj", turn)
