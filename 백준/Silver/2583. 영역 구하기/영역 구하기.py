import sys
sys.setrecursionlimit(10000)
m, n, k = map(int, input().split())
arr = [[0]*n for _ in range(m)]
visited = [[0]*n for _ in range(m)]

def dfs(i, j):
    global area
    area+=1
    visited[i][j] = 1
    for d in (-1,0), (0, -1), (1, 0), (0, 1):
        du = i+d[0]
        dv = j+d[1]
        if du<0 or dv<0 or du>=m or dv>=n:
            continue
        if arr[du][dv]==0 and not visited[du][dv]:
            dfs(du,dv)

for i in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for r in range(y1, y2):
        for c in range(x1, x2):
            arr[r][c] = 1


cnt = 0
answer = []
for r in range(m):
    for c in range(n):
        if arr[r][c] ==0 and not visited[r][c]:
            area = 0
            cnt += 1
            dfs(r,c)
            answer.append(area)

answer.sort()
print(cnt)
print(*answer)