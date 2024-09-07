from collections import deque


def bfs(i, j):
    visited = [[0] * m for _ in range(n)]
    visited[i][j] = 1
    q = deque([(i, j, 0)])
    while q:
        cr, cc, rank = q.popleft()
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1), (-1, -1), (-1, 1), (1, 1), (1, -1):
            du = cr + di
            dv = cc + dj
            if du < 0 or dv < 0 or du >= n or dv >= m:
                continue
            if visited[du][dv]:
                continue
            if arr[du][dv] == 1:
                return rank+1
            visited[du][dv] = 1
            q.append((du, dv, rank + 1))
    return 0


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
answer = 0

for i in range(n):
    for j in range(m):
        if arr[i][j]==0:
            answer = max(answer, bfs(i, j))
print(answer)