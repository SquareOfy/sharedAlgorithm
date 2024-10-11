from collections import deque


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= M


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
year = 0


def bfs(i, j):
    q = deque([(i, j)])
    visited[i][j] = 1

    while q:
        cr, cc = q.popleft()
        for di, dj in DIR:
            du, dv = cr+di, cc+dj
            if oob(du, dv): continue
            if arr[du][dv] == 0: continue
            if visited[du][dv]: continue
            q.append((du, dv))
            visited[du][dv] = 1




def check_bing():
    flag = False
    for i in range(N):
        for j in range(M):
            if arr[i][j] != 0 and not visited[i][j]:
                if flag:
                    return True
                flag = True
                bfs(i, j)
    return False
tmp = [[0] * M for _ in range(N)]


while 1:
    total = 0
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 0: continue
            total += 1
            for di, dj in DIR:
                du, dv = i + di, j + dj
                if oob(du, dv): continue
                if arr[du][dv] == 0:
                    tmp[i][j] += 1


    for i in range(N):
        for j in range(M):
            if arr[i][j] == 0: continue
            arr[i][j] = max(arr[i][j] - tmp[i][j], 0)
            tmp[i][j] = 0
            if arr[i][j] == 0:
                total -= 1
    if total == 0:
        year = 0
        break
    year += 1

    visited = [[0] * M for _ in range(N)]
    result = check_bing()
    if result:
        break

    # print("==========")
    # for i in range(N):
    #     print(arr[i])
    # print("====================")


print(year)


