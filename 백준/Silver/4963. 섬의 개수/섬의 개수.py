from collections import deque
def bfs(r, c):
    q = deque([(r, c)])
    visited[r][c] = 1

    while q:
        cr, cc = q.popleft()
        for di, dj in dir:
            du = cr+di
            dv = cc+dj
            if du<0 or dv<0 or du>=h or dv>=w:
                continue
            if visited[du][dv]:
                continue
            if arr[du][dv] == 1:
                q.append((du, dv))
                visited[du][dv] = 1

dir = (-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)

while 1:
    w, h = map(int, input().split())
    if w==0 and h==0:
        break

    arr = [list(map(int, input().split())) for _ in range(h)]
    visited = [[0]*w for _ in range(h)]
    answer = 0

    for i in range(h):
        for j in range(w):
            if arr[i][j]==1 and not visited[i][j]:
                bfs(i, j)
                answer+=1
    print(answer)