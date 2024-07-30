import sys
sys.setrecursionlimit(10000)
t = int(input())
direction = (-1, 0), (0, -1), (1, 0), (0, 1)
def dfs(i, j):
    visited[i][j] = 1

    for d in direction:
        du = i + d[0]
        dv = j + d[1]
        if du<0 or dv<0 or du>=n or dv>=m:
            continue
        if arr[du][dv] != 0 and not visited[du][dv]:
            dfs(du, dv)


for tc in range(t):
    m, n, k = map(int, input().split())
    arr = [[0] * m for _ in range(n)]
    visited = [[0] * m for _ in range(n)]
    for i in range(k):
        c, r = map(int, input().split())
        arr[r][c] = 1
    cnt = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j] != 0 and not visited[i][j]:
                dfs(i, j)
                cnt += 1
    print(cnt)