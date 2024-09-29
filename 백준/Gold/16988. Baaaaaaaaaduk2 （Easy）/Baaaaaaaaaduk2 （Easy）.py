'''
빈칸에 돌 두개 두어 죽일 수 있는 상대 돌의 최대 개수 구하기

돌 둘 자리 두개를 골라 그 자리에 돌을 넣는다
두개를 다 넣고 그룹별로 상하좌우에 빈칸이 있는지 본다
없으면 그 그룹을 죽인다.
상대편 그룹을 다 돌며 !!! !


# 2가 상대돌
'''

from collections import deque


def oob(du, dv):
    return du < 0 or dv < 0 or du >= N or dv >= M


def die_check(lst):
    for r, c in lst:
        for di, dj in DIR:
            du = r + di
            dv = c + dj
            if oob(du, dv): continue
            if arr[du][dv] == 0:
                return False
    return True


def kill_enemy():
    result = 0
    for lst in opposite_lst:
        if die_check(lst):
            result += len(lst)
    return result


def dfs(level, idx):
    global answer
    if level == 2:
        cnt = kill_enemy()
        answer = max(cnt, answer)
        return
    for i in range(idx, len(blank_lst)):
        r, c = blank_lst[i]
        arr[r][c] = 1
        dfs(level + 1, i + 1)
        arr[r][c] = 0


def bfs(i, j):
    q = deque([(i, j)])
    visited[i][j] = 1
    lst = []

    while q:
        cr, cc = q.popleft()
        lst.append((cr, cc))
        for di, dj in DIR:
            du, dv = cr + di, cc + dj
            if oob(du, dv) or visited[du][dv]:
                continue
            if arr[du][dv] == 2:
                q.append((du, dv))
                visited[du][dv] = 1

    opposite_lst.append(lst)


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
blank_lst = []
opposite_lst = []
visited = [[0] * M for _ in range(N)]
answer = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            blank_lst.append((i, j))
        elif arr[i][j] == 2 and not visited[i][j]:
            bfs(i, j)

dfs(0, 0)
print(answer)