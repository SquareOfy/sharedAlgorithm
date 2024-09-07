from collections import deque
def bfs(i, j):
    q = deque([(i, j)])
    visited[i][j] = 1

    while q:
        cr, cc = q.popleft()

        for di,dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = cr+di
            dv = cc+dj
            if du<0 or dv<0 or du>=n or dv>=m:
                continue
            if visited[du][dv] or arr[du][dv] == 0:
                continue
            visited[du][dv] = 1
            q.append((du,dv))
n, m = map(int, input().split())
arr = [[[0]*3 for _ in range(m)] for i in range(n)]
#reshape 쓰고싶네 입력 ;;
for i in range(n):
    line = list(map(int, input().split()))
    for j in range(m):
        for k in range(3):
            arr[i][j][k] = line[3*j + k]
t = int(input())
for i in range(n):
    for j in range(m):
        s = sum(arr[i][j])//3
        if s>=t:
            arr[i][j] = 255
        else:
            arr[i][j] = 0
visited = [[0]*m for _ in range(n)]
answer = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] == 255 and not visited[i][j]:
            bfs(i, j)
            answer += 1
print(answer)