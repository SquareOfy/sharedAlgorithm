from collections import deque
def change(i):
    if i=='W':
        return 0
    return 1

def oob(i, j):
    return i<0 or j<0 or i>=N or j>=M

def bfs(i, j):
    team = arr[i][j]
    q = deque([(i, j)])
    visited[i][j] = 1
    cnt = 0

    while q:
        cr, cc = q.popleft()
        cnt += 1
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du, dv = cr+di, cc+dj
            if oob(du, dv): continue
            if visited[du][dv]: continue
            if arr[du][dv] != team: continue
            q.append((du, dv))
            visited[du][dv] = 1
    score[team]+= cnt*cnt

M, N = map(int, input().split())

arr = [list(map(change, list(input()))) for _ in range(N)]
visited = [[0]*M for _ in range(N)]
score = [0]*2
for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            bfs(i, j)
print(*score)