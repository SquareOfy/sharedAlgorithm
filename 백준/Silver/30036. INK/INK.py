from collections import deque

def bfs(i, j, color, ink):
    visited = [[0]*N for _ in range(N)]
    q = deque([(i, j, 0)])
    visited[i][j] =1

    while q:
        r, c, rank = q.popleft()
        if arr[r][c]<=I and rank<=ink:
            arr[r][c] = color
            if rank ==ink:
                continue
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = r+di
            dv = c+dj

            if du<0 or dv<0 or du>=N or dv>=N or visited[du][dv]:
                continue
            q.append((du, dv, rank+1))
            visited[du][dv] = 1

#UDLR : 상하좌우

I, N, K = map(int, input().split())

color_lst = list(input())
arr = [list(input()) for _ in range(N)]
order = input()
r, c = -1, -1
ink = 0
dir = {'U' : (-1, 0), 'D' : (1, 0), 'R': (0, 1), 'L':(0, -1)}
jump_cnt = 0

for i in range(N):
    for j in range(N):
        if arr[i][j] == '@':
            r, c = i, j
            arr[i][j] = I+2
        elif arr[i][j] == '.':
            arr[i][j] = I+1
        elif arr[i][j] == '#':
            arr[i][j] = -1

for o in order:
    if o== 'j':
        ink += 1
    elif o in 'UDLR':
        di, dj = dir[o]
        du, dv = r+di, c+dj
        if du<0 or du>=N or dv<0 or dv>=N or (arr[du][dv]<=I):
            continue
        arr[r][c] = I+1
        r, c = du, dv
        arr[r][c] = I+2

    elif o == 'J':
        #쩜프
        color = (jump_cnt)%I
        bfs(r, c, color, ink)
        ink = 0
        jump_cnt+=1
for i in range(N):
    for j in range(N):
        if arr[i][j] == I+1:
            print('.', end="")
        elif arr[i][j] == I+2:
            print('@', end="")
        elif arr[i][j]==-1:
            print('#', end="")
        else:
            print(color_lst[(arr[i][j])%I], end="")
    print()