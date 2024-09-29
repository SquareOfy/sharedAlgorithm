from collections import deque

def bfs(i, j, num):
    q = deque([(i, j)])
    visited[i][j] = num
    cnt = 0
    while q:
        cr, cc = q.popleft()
        cnt+=1
        for di, dj in DIR:
            du = cr+di
            dv = cc+dj
            if du<0 or dv<0 or du>=N or dv>=M or visited[du][dv]:
                continue
            if arr[du][dv]==0:
                visited[du][dv] = num
                q.append((du, dv))
    cnt_dict[num] = cnt


N, M = map(int, input().split())
arr = [list(map(int, list(input()))) for _ in range(N)]
visited = [[0]*M for _ in range(N)]
cnt_dict = {}
idx = 0
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
for i in range(N):
    for j in range(M):
        if arr[i][j]==0 and not visited[i][j]:
            idx+=1
            bfs(i, j, idx)

for i in range(N):
    for j in range(M):
        if arr[i][j]==1:
            used_dict = {}
            for di, dj in DIR:
                du, dv = i+di, j+dj
                if du<0 or dv<0 or du>=N or dv>=M:
                    continue
                if visited[du][dv] !=0 and not used_dict.get(visited[du][dv], 0):
                    arr[i][j] =(arr[i][j] + cnt_dict[visited[du][dv]])%10
                    used_dict[visited[du][dv]] = 1

for k in range(N):
    print(*arr[k], sep="")