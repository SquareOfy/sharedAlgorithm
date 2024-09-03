from collections import deque
t = int(input())
dir = (-1, 0), (0, 1), (1, 0), (0, -1)
def spread_fire():

    while fire:
        cr, cc, rank = fire.popleft()
        for di, dj in dir:
            du = cr+di
            dv = cc+dj
            if du<0 or dv<0 or du>=h or dv>=w:
                continue
            if arr[du][dv] == '#':
                continue
            if fire_visited[du][dv]!=mm:
                continue
            fire_visited[du][dv] = rank+1
            fire.append((du, dv, rank+1))

def move(r, c):
    if fire_visited[r][c] <= 1:
        return 0
    visited = [[mm]*w for _ in range(h)]
    visited[r][c] = 1
    q = deque([(r, c, 1)])
    while q:
        cr, cc, rank = q.popleft()

        for di, dj in dir:
            du = cr+di
            dv = cc+dj
            if du<0 or dv<0 or du>=h or dv>=w:

                return rank
            if visited[du][dv]!=mm or arr[du][dv]=='#':
                continue

            if fire_visited[du][dv]<=rank+1:
                continue
            visited[du][dv] = rank+1
            q.append((du, dv, rank+1))
    return 0


for tc in range(1, t+1):
    w, h = map(int, input().split())
    arr = [list(input()) for _ in range(h)]
    mm = w*h+1
    fire = deque([])
    fire_visited = [[mm]*w for _ in range(h)]
    sr, sc = -1, -1
    for i in range(h):
        for j in range(w):
            if arr[i][j]=='*':
                fire.append((i, j, 1))
                fire_visited[i][j]=1
            elif arr[i][j]=='@':
                sr, sc = i, j
    spread_fire()

    #상근이 이동시키기
    answer = move(sr, sc)
    print(answer if answer else 'IMPOSSIBLE')