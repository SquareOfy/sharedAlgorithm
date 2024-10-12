from collections import deque


def oob(i, j, k):
    return i < 0 or j < 0 or k < 0 or i >= L or j >= R or k >= C


def find_start_point():
    for i in range(L):
        for j in range(R):
            for k in range(C):
                if arr[i][j][k] == 'S':
                    return i, j, k


def bfs():
    q = deque([(si, sj, sk, 0)])
    visited = [[[0] * C for _ in range(R)] for _ in range(L)]
    visited[si][sj][sk] = 1

    while q:
        ci, cj, ck, rank = q.popleft()
        if arr[ci][cj][ck] == 'E':
            return rank
        for di, dj, dk in DIR:
            du, dv, dw = ci + di, cj + dj, ck + dk
            if oob(du, dv, dw): continue
            if visited[du][dv][dw]: continue
            if arr[du][dv][dw] == '#': continue
            q.append((du, dv, dw, rank + 1))
            visited[du][dv][dw] = 1
    return -1


DIR = (-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)
while 1:
    L, R, C = map(int, input().split())
    if L == 0 and R == 0 and C == 0:
        break
    arr = [[] for _ in range(L)]
    for i in range(L):
        arr[i] = [list(input()) for _ in range(R)]
        input()

    si, sj, sk = find_start_point()

    answer = bfs()
    print(f"Escaped in {answer} minute(s)." if answer != -1 else "Trapped!")