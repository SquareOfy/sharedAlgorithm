my_bingo = [list(map(int, input().split())) for _ in range(5)]
called_bingo = [list(map(int, input().split())) for _ in range(5)]


def erase(i):
    for r in range(5):
        for c in range(5):
            if my_bingo[r][c] == i:
                my_bingo[r][c] = 0
                return r, c


def check_bingo(i):
    global bingo
    r, c = erase(i)

    h = 0
    w = 0
    for k in range(5):
        if my_bingo[r][k] == 0:
            w += 1
        if my_bingo[k][c] == 0:
            h += 1
    if w == 5:
        bingo += 1
    if h == 5:
        bingo += 1
    cross1 = 0
    if r == c:
        for k in range(5):
            if my_bingo[k][k] == 0:
                cross1 += 1
            else:
                break
    if cross1 == 5:
        bingo += 1

    cross2 = 0
    if r == 4 - c:
        for k in range(5):
            if my_bingo[k][4 - k] == 0:
                cross2 += 1
            else:
                break
    if cross2 == 5:
        bingo += 1


bingo = 0
cnt = 0


def pro():
    global cnt
    for lst in called_bingo:
        for i in lst:
            cnt += 1
            check_bingo(i)
            if bingo >= 3:
                print(cnt)
                return
pro()
