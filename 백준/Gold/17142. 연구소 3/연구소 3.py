"""
총 풀이시간 21분


처음 모든 바이러스 비활성 상태

활성 바이러스 상하좌우 빈칸을 "!!!동시!!!" 복제
복제에 1초 소요

바이러스 M개 활성상태로 변경하려고 함
활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 => 활성 됨

0 빈칸
1 벽
2 바이러스



모든 빈칸에 바이러스를 퍼뜨리는 최소 시간 ...

빈칸 개수 세고 바이러스 퍼질 때마다 -1 시켜서 0될때 시간 min 갱신하자 .


바이러스 M개 고르기 2500 C 10 ? 시간 내에 되나
virus = []
dfs(level, idx, lst)
    level == M:
        bfs(lst)

    for i in range(idx, len(virus)

"""
from collections import deque
def dfs(level, idx, lst):
    global answer
    if level == M:
        s = bfs(lst)
        answer = min(s, answer)
        return
    for i in range(idx, v):
        dfs(level+1, i+1, lst+[i])

#lst에 고른 바이러스들 활성화시켜서 퍼뜨리고 전체 소요된 시간 반환
def bfs(lst):
    q = deque([])
    visited = [[0]*N for _ in range(N)]
    b = blank
    for i in lst:
        r, c = virus[i]
        q.append([r, c, 0])
        visited[r][c] = 1

    while q:
        r, c, rank = q.popleft()
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = r+di
            dv = c+dj
            if du<0 or dv<0 or du>=N or dv>=N:
                continue
            if visited[du][dv] or arr[du][dv]==1:
                continue
            if arr[du][dv] == 0:
                b-=1
                if b==0:
                    return rank+1
            visited[du][dv] = 1
            q.append((du, dv, rank+1))
    return N*N+1
N, M = map(int,input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
virus = []
blank = 0
answer = N*N+1
for i in range(N):
    for j in range(N):
        if arr[i][j] == 0:
            blank+=1
        elif arr[i][j]==2:
            virus.append((i, j))
v = len(virus)
if blank == 0:
    print(0)
else:
    dfs(0, 0, [])
    print(answer if answer!=N*N+1 else -1)