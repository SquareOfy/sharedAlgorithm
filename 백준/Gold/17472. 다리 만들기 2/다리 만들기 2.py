from collections import deque

def dfs(level,  lst, dist_sum):
    if level == idx:
        global answer
        answer = min(dist_sum, answer)
        return

    for i in lst:
        for k in range(1, idx+1):
            if selected[k] or dist_arr[i][k] == inf: continue
            selected[k] =1
            dfs(level+1, lst+[k], dist_sum+dist_arr[i][k])
            selected[k] = 0


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= M


def bfs(i, j, idx):
    q = deque([(i, j)])
    visited[i][j] = idx
    lst = [(i, j)]
    while q:
        cr, cc = q.popleft()
        flag = True
        for di, dj in DIR:
            du = cr + di
            dv = cc + dj

            if oob(du, dv):
                continue
            if flag and arr[du][dv] == 0:
                flag = False
                lst.append((cr, cc))
                continue
            if arr[du][dv] == 1 and not visited[du][dv]:
                q.append((du, dv))
                visited[du][dv] = idx

    side_lst.append(lst)


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
idx = 0
side_lst = [-1]
inf = N*M
answer = inf
for i in range(N):
    for j in range(M):
        if not visited[i][j] and arr[i][j] == 1:
            idx += 1
            bfs(i, j, idx)


dist_arr = [[inf]*(idx+1) for _ in range(idx+1)]

for i in range(1, idx+1):
    for si, sj in side_lst[i]:
        for di, dj in DIR:
            ni, nj = si+di, sj+dj
            l = 0
            while not oob(ni, nj) and visited[ni][nj] ==0:
                l += 1
                ni += di
                nj += dj
            if not oob(ni, nj) and l>=2:
                cnum = visited[ni][nj]
                dist_arr[i][cnum] = min(l, dist_arr[i][cnum])
                dist_arr[cnum][i] = min(l, dist_arr[cnum][i])

selected = [0]*(idx+1)
selected[1] = 1
dfs(1, [1], 0)
print(answer if answer!= inf else -1)
