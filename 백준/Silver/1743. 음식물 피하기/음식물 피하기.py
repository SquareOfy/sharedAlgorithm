from collections import deque

n, m, k = map(int, input().split())
arr = [[0]*m for _ in range(n)]
dr = (-1, 0, 1, 0)
dc = (0, -1, 0, 1)

def bfs(r, c):
    q = deque([[r,c]])
    result = 0

    while len(q) != 0:
        now = q.popleft()
        result +=1

        for i in range(4):
            du = now[0] + dr[i]
            dv = now[1] + dc[i]

            if du<0 or dv<0 or du>=n or dv>=m:
                continue
            if arr[du][dv] == 1:
                arr[du][dv] = -1
                q.append([du,dv])
    return result

for i in range(k):
    r , c = map(int, input().split())
    arr[r-1][c-1] = 1

answer = 0
for r in range(n):
    for c in range(m):
        if arr[r][c] == 1:
            arr[r][c] = -1
            cnt = bfs(r, c)
            answer = max(answer, cnt)
print(answer)

