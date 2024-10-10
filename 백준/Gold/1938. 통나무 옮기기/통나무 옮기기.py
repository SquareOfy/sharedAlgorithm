from collections import deque


def bfs():
    sr, sc, sd = start
    q = deque([(sr, sc, sd, 0)])
    visited[sr][sc][sd] = 1
    while q:
        r, c, d, rank = q.popleft()

        if [r, c, d] == target:
            return rank
        for i in range(5):
            if is_possible(r, c, d, i):
                nr, nc, nd = move(r, c, d, i)
                if visited[nr][nc][nd]:
                    continue
                q.append((nr, nc, nd, rank + 1))
                visited[nr][nc][nd] = 1
    return 0


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= N


def move(r, c, d, o):
    if o == 4:
        return r, c, (d + 1) % 2
    di, dj = DIR[o]
    return r + di, c + dj, d


def is_possible(r, c, d, order):
    lst = DIR_DICT[(d, order)]

    for di, dj in lst:
        du = r + di
        dv = c + dj
        if oob(du, dv):
            return False
        if arr[du][dv]:
            return False
    return True


N = int(input())

arr = [list(input()) for _ in range(N)]
b_cnt = 0
b_first = None
e_cnt = 0
e_first = None
start = [None, None, None]
target = [None, None, None]
inf = float('inf')
answer = inf

DIR_DICT = {
    (0, 0): [(-1, -1), (-1, 0), (-1, 1)],
    (0, 1): [(1, -1), (1, 0), (1, 1)],
    (0, 2): [(0, -2)],
    (0, 3): [(0, 2)],
    (0, 4): [(-1, -1), (-1, 0), (-1, 1), (1, -1), (1, 0), (1, 1)],
    (1, 0): [(-2, 0)],
    (1, 1): [(2, 0)],
    (1, 2): [(-1, -1), (0, -1), (1, -1)],
    (1, 3): [(-1, 1), (0, 1), (1, 1)],
    (1, 4): [(-1, -1), (0, -1), (1, -1), (-1, 1), (0, 1), (1, 1)]
}
DIR = (-1, 0), (1, 0), (0, -1), (0, 1)

for i in range(N):
    for j in range(N):
        if arr[i][j] == 'B':
            b_cnt += 1
            arr[i][j] = '0'
            if b_cnt == 2:
                start[0] = i
                start[1] = j
                start[2] = 0 if b_first[0] == i else 1
            else:
                b_first = (i, j)
        if arr[i][j] == 'E':
            e_cnt += 1
            arr[i][j] = '0'
            if e_cnt == 2:
                target[0] = i
                target[1] = j
                target[2] = 0 if e_first[0] == i else 1

            else:
                e_first = (i, j)

arr = [list(map(int, arr[i])) for i in range(N)]
visited = [[[0] * 2 for _ in range(N)] for _ in range(N)]
# dfs(0, start)
answer = bfs()
print(answer if answer != inf else 0)
