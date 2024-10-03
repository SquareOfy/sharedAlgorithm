"""
N×N 크기의 도시
병원과 벽을 제외한 모든 지역에 바이러스
M개의 병원을 적절히 고르기

골라진 병원들을 시작으로 매 초마다 상하좌우로 인접한 지역 중 벽을 제외한 지역에
백신이 공급되기 때문에 그 자리에 있던 바이러스는 사라지게 됩니다.


M개의 병원을 적절히 골라 바이러스를 전부 없애는데 걸리는 시간 중 최소 시간을 구하는 프로그램


0 : 바이러스
1 : 벽
2 : 병원

3≤N≤50
1≤M≤10

출력
M개의 병원을 적절히 골라 모든 바이러스를 없애는 데 필요한 최소 시간을 출력
모든 바이러스를 없앨 수 있는 방법이 없다면 −1을 출력
"""

from collections import deque

def bfs(lst):
    q = lst[:]
    visited = [[0]*N for _ in range(N)]
    for i, j in q:
        visited[i][j] = 1
    cnt = 0
    time = 0
    while q:
        nq = []

        for cr, cc, in q:
            for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
                du, dv = cr+di, cc+dj
                if du<0 or dv<0 or du>=N or dv>=N:
                    continue
                if visited[du][dv] or arr[du][dv] ==1:
                    continue
                visited[du][dv] = 1
                nq.append((du, dv))
                if arr[du][dv] == 0:
                    cnt += 1
        time+=1
        if cnt==virus_cnt:
            break
        q = nq

    return cnt==virus_cnt, time


def dfs(level, idx, lst):
    global answer
    if level==M:
        flag, time = bfs(lst)
        if flag:
            answer = min(answer, time)
        return

    for i in range(idx, len(hospital_lst)):
        dfs(level+1, i+1, lst+[hospital_lst[i]])

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
hospital_lst = []
virus_cnt = 0
for i in range(N):
    for j in range(N):
        if arr[i][j] == 2:
            hospital_lst.append((i, j))
        elif arr[i][j] == 0:
            virus_cnt+=1
answer=  N*N
if virus_cnt!=0:
    dfs(0, 0, [])
else:
    answer = 0
print(answer if answer != N*N else -1)