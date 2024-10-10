def oob(i, j):
    return i < 0 or j < 0 or i >= 6 or j >= 6


arr = [[-1] * 6 for _ in range(6)]
arr[2][2] = 0
arr[3][3] = 0
arr[2][3] = 1
arr[3][2] = 1
DIR = (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)
N = int(input())
dol = 1
for i in range(N):
    r, c = map(lambda x: int(x) - 1, input().split())
    arr[r][c] = dol

    for di, dj in DIR:
        du, dv = r + di, c + dj
        if oob(du, dv): continue
        lst = []
        while not oob(du, dv) and arr[du][dv] == dol ^ 1:
            lst.append((du, dv))
            du += di
            dv += dj
        if oob(du, dv) or arr[du][dv] != dol:
            continue

        for ni, nj in lst:
            arr[ni][nj] = dol

    dol ^= 1

black_cnt = 0
white_cnt = 0
for i in range(6):
    for j in range(6):
        if arr[i][j] == -1:
            arr[i][j] = '.'
        elif arr[i][j] == 1:
            black_cnt += 1
            arr[i][j] = 'B'
        else:
            white_cnt += 1
            arr[i][j] = 'W'
    print(*arr[i], sep="")
print('Black' if black_cnt>white_cnt else 'White')
