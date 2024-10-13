from collections import deque
def bfs():
    q = deque([(0, 0)])
    visited[0][0] = 1

    while q:
        cr, cc = q.popleft()
        for di, dj in (1, 0), (0, -1), (-1, 0), (0, 1):
            du, dv = cr+di, cc+dj
            if du<0 or dv<0 or du>=N or dv>=M: continue
            if arr[du][dv] == 1:
                visited[du][dv] += -1
                continue
            if visited[du][dv]!=0: continue
            q.append((du,dv))
            visited[du][dv] = 1



N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
before_cnt = 0
time = 0
while 1:

    cnt = 0
    delete_cnt = 0
    visited = [[0]*M for _ in range(N)]
    bfs()

    for i in range(N):
        for j in range(M):
            if arr[i][j]==0: continue
            cnt+=1
            if visited[i][j]<0:
                arr[i][j] = 0
                delete_cnt+=1

    if cnt==0:
        break
    before_cnt = cnt

    time +=1
print(time)
print(before_cnt)