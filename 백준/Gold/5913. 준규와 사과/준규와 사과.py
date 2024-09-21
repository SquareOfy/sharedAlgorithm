def dfs(level, r, c):
    global answer
    if r==4 and c==4 and level == 24-k:
        answer += 1
        return
    for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
        du, dv = r+di, c+dj
        if du<0 or dv<0 or du>=5 or dv>=5:
            continue
        if visited[du][dv]:
            continue
        visited[du][dv] = 1
        dfs(level+1, du, dv)
        visited[du][dv] = 0

k = int(input())
visited = [[0]*5 for _ in range(5)]
for i in range(k):
    r, c = map(int, input().split())
    visited[r-1][c-1] = 1

answer = 0
visited[0][0] = 1
dfs(0, 0, 0)
print(answer)