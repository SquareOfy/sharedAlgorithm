"""


N행  M열 격자 위에서 진행
격자 각 칸은 벽 또는 빈칸. 벽은 못감

 어느 빈칸에서 출발해도 다른 모든 빈칸으로 이동할 수 있다.
 다섯 면이 막혀있고 나머지 한 면이 뚫려있는 정육면체
탐정은 자신이 있는 칸에 감옥의 뚫린 면이 바닥을 향하게 하여 놓는다.
감옥은 상하좌우 중 벽이 없는 한 방향으로 굴릴 수 있고, 그에 따라 바닥을 향하는 면이 바뀌게 된다.
이동하려는 칸의 바닥과 수직으로 접하고 있는 면이 이동 후 바닥을 향하게 된다.
도둑을 감옥에 가두려면, 감옥의 뚫린 면이 바닥을 향할 때 도둑이 같은 칸에 있어야 한다

만약 막힌 면이 바닥을 향할 때 도둑이 같은 칸에 있다면 도둑은 바로 승리를 선언하고 탐정은 패배하게 된다.

당신 = 탐정
도둑을 감옥으로 가두기만 하면 승리할 수 있다.
당신의 위치와 도둑의 위치가 주어질 때, 감옥을 최소 몇 번 굴려야 당신이 게임에서 승리


# : 벽
. 빈칸
탐정 D
도둑 R
탐정이 승리할 수 있다면 도둑을 가두는데 필요한 최소 이동 횟수를 출력한다.

그렇지 않다면 -1을 출력한다.
"""

from collections import deque


def change_dice(top, bottom, dice, i):
    t, b, di = top, bottom, dice[:]
    tmp = b
    b = di[i]
    di[i] = t
    t = di[(i + 2) % 4]
    di[(i + 2) % 4] = tmp
    return t, b, di


def find(c):
    for i in range(N):
        for j in range(M):
            if arr[i][j] == c:
                return i, j


# bfs
def bfs():
    global answer

    q = deque([(D_r, D_c, 0, 5, [1, 2, 3, 4], 1)])
    visited[D_r][D_c][0] = 1

    while q:
        cr, cc, bottom, top, dice, rank = q.popleft()
        # if arr[cr][cc] == 'R':
        #     answer = rank-1
        #     break
        for d in range(4):
            di, dj = DIR[d]
            du, dv = cr + di, cc + dj
            if arr[du][dv] == '#':
                continue  # 범위, 벽

            nt, nb, ndice = change_dice(top, bottom, dice, d)
            if arr[du][dv]=='R' and nb !=0:
                continue

            #구멍의 위치 index
            if nb ==0:
                idx = 0
            elif nt ==0:
                idx = 5
            else:
                idx = ndice.index(0)+1
            if visited[du][dv][idx] <= rank+1:
                continue
            visited[du][dv][idx] = rank+1
            q.append((du, dv, nb, nt, ndice, rank+1))




# 입력
N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]

# 필요 배열 세팅
visited = [[[1e9 for _ in range(6)] for _ in range(M)] for _ in range(N)]
answer = -1
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
D_r, D_c = find('D')
R_r, R_c = find('R')

# bfs
bfs()
# 출력
answer = visited[R_r][R_c][0]

print(answer-1 if answer != 1e9 else -1)