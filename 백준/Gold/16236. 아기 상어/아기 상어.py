from collections import deque
def find_shark():
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 9:
                arr[i][j] = 0
                return i, j

def bfs(i, j):
    q = deque([(i, j, 1)]) #시작 상어 위치
    visited = [[0]*n for _ in range(n)]
    visited[i][j] = 1
    t = n*n
    ar, ac = n, n
    while q:
        # print(" ================== queue ===================")
        cr, cc, rank = q.popleft()
        # print(cr, cc, rank)
        if rank <= t and arr[cr][cc] != 0 and arr[cr][cc] < size:
            #갱신
            t = rank
            if cr < ar:
                ar, ac = cr, cc
            elif cr==ar and cc<ac:
                ac = cc
            continue
        for di, dj in (-1, 0), (0, -1), (1, 0), (0, 1):
            du = cr+di
            dv = cc+dj

            if du<0 or dv<0 or du>=n or dv>=n:
                continue
            if visited[du][dv] or arr[du][dv] > size:
                continue
            visited[du][dv] = 1
            q.append((du, dv, rank+1))
    return ar, ac, t-1
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
sr, sc = find_shark()
answer = 0
size = 2
cnt  = 0
while 1:
    # print('+=======================')
    # print(sr, sc)
    sr, sc, time = bfs(sr, sc)
    # print(sr, sc, time)
    if sr == n:
        break
    answer += time
    cnt += 1
    arr[sr][sc] = 0

    # print("여기 왜 안돼")
    # for i in range(n):
    #     print(arr[i])
    if cnt == size:
        size+=1
        cnt = 0

print(answer)
