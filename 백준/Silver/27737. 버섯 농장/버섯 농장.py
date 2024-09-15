from collections import deque

def bfs(i, j):
    visited[i][j] = 1
    q = deque([(i, j)])
    cnt = 0
    while q:
        r, c = q.popleft()
        cnt+=1
        for di, dj in (-1, 0), (0, 1) ,(1, 0), (0, -1):
            du = r+di
            dv = c+dj
            if du<0 or dv<0 or du>=N or dv>=N or visited[du][dv] or arr[du][dv]==1:
                continue
            q.append((du, dv))
            visited[du][dv] = 1
    return cnt
# N*N 배열 / M개의 버섯포자 / K개의 영역으로 퍼지기 가능
N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
answer = 'IMPOSSIBLE'
cnt = 0
visited = [[0] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if arr[i][j] == 0 and not visited[i][j]:
           tmp =  bfs(i, j)
           cnt += tmp//K +1 if tmp%K !=0 else tmp//K

if cnt==0 or M-cnt <0:
    print('IMPOSSIBLE')
else:
    print('POSSIBLE')
    print(M-cnt)