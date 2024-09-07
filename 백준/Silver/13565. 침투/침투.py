from collections import deque

def bfs(i, j):
    visited[i][j] = 1
    q = deque([(i, j)])

    while q:
        cr, cc = q.popleft()
        if cr == n-1:
            return True
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = cr+di
            dv = cc+dj
            if du<0 or dv<0 or du>=n or dv>=m:
                continue
            if visited[du][dv] or arr[du][dv] == 1:
                continue
            q.append((du, dv))
            visited[du][dv] = 1
    return False
n, m = map(int, input().split())
arr = [list(map(int, list(input()))) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
answer = "NO"
for i in range(m):
    if arr[0][i] == 0 and not visited[0][i]:
        if bfs(0, i):
            answer = "YES"
            break
print(answer)