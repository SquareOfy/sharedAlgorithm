from collections import deque
def bfs(r, c):
    q = deque([(r, c, 0)])
    visited = [[0] * M for _ in range(N)]
    visited[r][c] = 1
    while q:
        cr, cc, rank = q.popleft()
        if arr[cr][cc]=='B':
            return rank
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = cr+di
            dv = cc+dj
            if oob(du, dv) or visited[du][dv] or arr[du][dv]=='X':
                continue
            visited[du][dv] = 1
            q.append((du, dv, rank+1))
    return -1


def oob(i, j):
    return i<0 or i>=N or j<0 or j>=M


N, M, P = map(int, input().split())
arr = [list(input()) for _ in range(N)]
player_dict = {}
for i in range(P):
    id, dps = input().split()
    dps = int(dps)
    player_dict[id] = dps
hp = int(input())
arrived_dict = {}
for i in range(N):
    for j in range(M):
        if arr[i][j]!='.' and arr[i][j]!='X' and arr[i][j]!='B':
            time = bfs(i, j)
            tmp = arrived_dict.get(time, (0, 0))
            arrived_dict[time] = (tmp[0]+player_dict[arr[i][j]], tmp[1]+1)

arrived_lst = []
for k, v in arrived_dict.items():
    arrived_lst.append((k, v[0], v[1]))
arrived_lst.sort()

now = 0
power = 0
answer = 0
for time, p, man in arrived_lst:
    hp -= (time-now)*power
    if hp<=0:
        break
    # hp -= p
    answer+=man
    now = time
    # hp -= power
    power += p
    # if hp<0:
    #     break


print(answer)