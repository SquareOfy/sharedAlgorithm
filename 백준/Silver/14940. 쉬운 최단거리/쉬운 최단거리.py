from collections import deque
n, m = map(int, input().split())
#모든 지점에서 2에 도달하기 위한 최단 거리를 구하는 문제이므로
#시작 지점에서 갈 수 있는 모든 지점을 bfs로 돌고
#그때마다  배열에 rank 기록하기
#단, 기존 배열도 숫자여서 도달할 수 없는 구역을 변별하기 쉽지 않으므로
#기존 배열 값에 -1 곱하기

def set_ground(i):
    return -int(i)
ground = [list(map(set_ground, input().split())) for _ in range(n)]
start =()
for i in range(n):
    for j in range(m):
        if ground[i][j] == -2:
            start = (i,j, 0)
        elif ground[i][j] == 0:
            ground[i][j] = '.'

visited = [[0]*m for _ in range(n)]
q = deque([start])

visited[start[0]][start[1]] = 1

while q:
    now = q.popleft()
    ground[now[0]][now[1]] = now[2]
    for d in (-1, 0), (0, -1), (1, 0), (0, 1):
        du = now[0] + d[0]
        dv = now[1] + d[1]
        if du<0 or dv<0 or du>=n or dv>=m:
            continue

        if not visited[du][dv] and ground[du][dv]!='.' and ground[du][dv]<0:
            visited[du][dv] = 1
            q.append((du, dv, now[2]+1))


for i in range(n):
    for j in range(m):
        if ground[i][j] =='.':
            ground[i][j] = 0
    print(*ground[i])


