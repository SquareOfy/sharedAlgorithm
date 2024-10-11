from collections import deque


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= N


def find_land(i, j):
    q = deque([(i, j)])
    land_arr[i][j] = land
    lst = []
    while q:
        cr, cc = q.popleft()
        flag = False
        for di, dj in DIR:
            du, dv = cr + di, cc + dj
            if oob(du, dv): continue
            if land_arr[du][dv]: continue
            if arr[du][dv] == 0:
                flag = True
                continue
            q.append((du, dv))
            land_arr[du][dv] = land

        if flag:
            side_lst.append((cr, cc))
    return lst
def bfs(r, c, land_num, idx):
    q = deque([(r, c, 0)])
    visited[r][c] = 1

    while q:
        cr, cc, rank = q.popleft()
        if land_arr[cr][cc] > 0 and land_arr[cr][cc]!=land_num:
            return rank-1
        for di, dj in DIR:
            du, dv = cr+di, cc+dj
            if oob(du, dv):
                continue
            if land_arr[du][dv] == land_num:
                continue
            if visited[du][dv] == idx:
                continue
            visited[du][dv] = idx
            q.append((du, dv, rank+1))
    return inf

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
land_arr = [[0] * N for _ in range(N)]
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
land = 0
side_lst = []
inf = N*N
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1 and not land_arr[i][j]:
            land += 1
            find_land(i, j)
visited = [[0] * N for _ in range(N)]
answer = inf





for i in range(len(side_lst)):
    r, c = side_lst[i]
    length = bfs(r, c, land_arr[r][c], i+1)
    answer = min(answer ,length)
print(answer)