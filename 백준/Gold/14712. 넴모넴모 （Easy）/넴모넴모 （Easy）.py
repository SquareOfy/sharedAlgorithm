def dfs(r, c):
    global cnt
    if r==n:
        cnt+=1
        return

    #좌대각 좌 상 체크
    if r>0 and c>0:
        if visited[r-1][c-1] and visited[r-1][c] and visited[r][c-1]:
            if c + 1 == m:
                dfs(r + 1, 0)
            else:
                dfs(r, c + 1)
            return
    visited[r][c] = 1
    if c+1 ==m:
        dfs(r+1, 0)
    else:
        dfs(r, c+1)
    visited[r][c] = 0
    if c+1 ==m:
        dfs(r+1, 0)
    else:
        dfs(r, c+1)




def fill_v(r,c, f):
    print(r, c, f)
    for i in range(2):
        for j in range(2):
            visited[r+i][c+j] = f

n, m = map(int, input().split())
cnt = 0
visited = [[0]*m for _ in range(n)]
dfs(0, 0)
print(cnt)