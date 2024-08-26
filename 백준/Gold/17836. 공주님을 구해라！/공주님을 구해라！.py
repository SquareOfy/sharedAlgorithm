"""
용사 상하좌우로 이동 가능
T시간 이내에 공주를 찾아야 함
한번 이동 = 한시간
(1,1) -> (N,M)으로 가야함
마법 벽 통과 불가
그람 만나면 통과 가능해짐( 그람 여부를 BFS에 들고 다닐 것)
그람 만난 이후로 부술 벽 횟수 제한 없음

0 : 빈공간
1 : 벽
2 : 그람
"""
from collections import deque
def bfs():
    q = deque([[0,0,0,0]]) #r, c, rank, 그람여부
    visited[0][0][0]=1

    while q:
        r, c, rank, gram = q.popleft()
        if r==N-1 and c==M-1:
            return rank
        if rank>T:
            return -1
        for di, dj in (-1, 0), (0, -1), (1, 0), (0, 1):
            du, dv = r+di, c+dj
            if du<0 or dv<0 or du>=N or dv>=M:
                continue
            if not gram and arr[du][dv]==1:
                continue
            if visited[gram][du][dv]:
                continue

            visited[gram][du][dv] = 1
            if arr[du][dv]==2:
                q.append([du, dv, rank+1, 1])
            else:
                q.append([du, dv, rank+1, gram])
    return -1

N, M, T = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[[0]*M for _ in range(N)] for i in range(2)]
answer = bfs()
if answer == -1:
    print('Fail')
else:
    print(answer)