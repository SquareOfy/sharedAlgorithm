"""

얼음 3 이상 인접이 이해가 안간다 ...
"""
from collections import deque
def bfs(r, c):
    q = deque([(r,c)])
    visited[r][c] = 1
    result = 0
    while q:
        cr, cc = q.popleft()
        result+=1
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = cr+di
            dv = cc+dj
            if du<0 or dv<0 or du>=N or dv>=N:
                continue
            if visited[du][dv] or arr[du][dv] == 0:
                continue
            visited[du][dv] = 1
            q.append((du, dv))
    return result
n, Q = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(2**n)]
lst = list(map(int, input().split()))
N = 2**n
for q in range(Q):
    l = 2**lst[q]

    #l만큼 나눠서 시계방향 회전하기
    for r in range(0, N, l):
        for c in range(0, N, l):
            #r,c가 길이가 2**l인 사각형의 시작점
            tmp = [arr[k][c:c+l] for k in range(r, r+l)]
            tmp = [list(k) for k in list(zip(*tmp[::-1]))]
            for k in range(l):
                arr[r+k][c:c+l] = tmp[k]

    #회전 구현 완료

    ice = [[0]*N for _ in range(N)]
    #얼음 녹이기 완료
    for r in range(N):
        for c in range(N):
            if arr[r][c] == 0:
                continue
            cnt = 0
            for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
                if cnt ==3:
                    break
                du = r+di
                dv = c+dj
                if du<0 or dv<0 or du>=N or dv>=N:
                    continue
                if arr[du][dv] !=0:
                    cnt += 1
            if cnt<3:
                ice[r][c] -=1
    for r in range(N):
        for c in range(N):
            arr[r][c] += ice[r][c]
            ice[r][c] = 0
#모든 파이어볼 완료

#출력값 준비하기

#전체 합
s = 0
for i in range(N):
    s+= sum(arr[i])
print(s)
#전체합 일치 확인


#제일 큰 얼음덩어리의 칸 개수
answer = 0
visited = [[0]*N for _ in range(N)]

for r in range(N):
    for c in range(N):
        if visited[r][c] or arr[r][c]==0:
            continue
        size = bfs(r, c)
        answer = max(size, answer)
print(answer)