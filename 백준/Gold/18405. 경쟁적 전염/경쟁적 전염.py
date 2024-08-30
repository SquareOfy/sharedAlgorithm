# 바이러스 : 1~ k 중 하나
# 1초마다 상하좌우로 증식하고, 번호가 낮은 종류의 바이러스부터 증식
#특정 칸에 이미 바이러스 존재하면 그 곳에 다른 바이러스 증식 불가

# s초가 지난 후 x,y(행, 열)에 존재하는 바이러스 종류 출력
# 해당 위치에 바이러스 없으면 0 출력

#인덱스 문제에서 1 부터 시작

from collections import deque

n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
s, x, y = map(int, input().split())

#바이러스 1부터 k까지를 deque에 담아놓기
virus = [[]]
for i in range(k):
    virus.append(deque())
for i in range(n):
    for j in range(n):
        if arr[i][j] != 0:
            virus[arr[i][j]].append((i, j, 0))
t = 0
while t!=s:
    #바이러스 1부터 k까지 증식시킬 것.
    for v in range(1, k+1):
        while virus[v]:
            r, c, rank = virus[v].popleft()

            if rank > t:
                virus[v].append((r,c, rank))
                break

            for di, dj in (-1, 0), (0, -1), (1, 0), (0, 1):
                du = r+di
                dv = c+dj
                if du<0 or dv<0 or du>=n or dv>=n or arr[du][dv]!=0:
                    continue
                arr[du][dv] = v
                virus[v].append((du,dv,rank+1))
    t+=1
print(arr[x-1][y-1])