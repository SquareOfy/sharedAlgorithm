def oob(i, j):
    return i<0 or j<0 or i>=N or j>=N


def update_visited(r, c, num):
    for di, dj in dir:
        du, dv = r, c
        while 1:
            du += di
            dv += dj
            if oob(du, dv) or arr[du][dv]!='.':
                break
            visited[du][dv]=num


N = int(input())
arr = [list(input()) for _ in range(N)]
visited = [[0] * N for _ in range(N)]
dir = (-1, 0), (0, 1), (1, 0), (0, -1)


for i in range(N):
    for j in range(N):
        if arr[i][j] == 'X':
            update_visited(i, j, 1)
for i in range(N):
    for j in range(N):
        if arr[i][j] == 'O':
            update_visited(i, j, 0 )

for i in range(N):
    for j in range(N):
        if arr[i][j]=='.' and visited[i][j] ==1:
            arr[i][j] = 'B'

for i in range(N):
    print(*arr[i], sep="")