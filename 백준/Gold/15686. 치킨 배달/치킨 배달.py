

"""
1533 문제 이해 완 + 대략 구상 완료 ( 백트래킹 사용할 것)
1554 구현 완료 코드트리 제출했지만 시간초과 ... 
1614 백트래킹완료 후 최단거리 계산하는 방식 병원 위주로 코드 변경 후 제출

1614 백준 문제 파악 시작
1618 치킨집으로부터 집과의 최단거리 배열 갱신하는 부분에서 continue 추가함


전체 치킨 집 중 폐업시키지 않을 치킨집 m개 고르기
다 고른 후 그 치킨집으로부터 집 거리 갱신. 


"""
from collections import deque
#def : 병원들 중 m개 고르는 함수
def pick_hospitals(level, idx):
    global answer
    if k-idx < m-level:
        return
    #종료 조건 : m개 다 고르면 고른 병원들로 사람들 사이의 최단 병원거리 갱신
    if level == m:
        # print(selected)
        tmp = 0
        dist = [[inf]*n for _ in range(n)]
        #거리 재기. 더 빠른 방법은?
        #사람으로부터 재지 말고 병원으로부터 재자. 개수가 훨씬 적다
        for h in selected:
            calculate(h, dist)
        for i in range(n):
            for j in range(n):
                if dist[i][j]!=inf:
                    tmp+= dist[i][j]

        answer = min(answer, tmp)
        return

    for i in range(idx, k):
        h = hospitals[i]
        selected[level] = h
        arr[h[0]][h[1]] = -2
        pick_hospitals(level+1, i+1)
        arr[h[0]][h[1]] = 2

def calculate(p,dist):
    visited = [[0] * n for _ in range(n)]
    q = deque([[p[0], p[1], 0]])
    visited[p[0]][p[1]] = 1
    while q:
        cr, cv, rank = q.popleft()
        for d in (-1, 0), (0, -1), (1, 0), (0,1):
            du, dv = cr+d[0], cv+d[1]
            if du<0 or dv<0 or du>=n or dv>=n:
                continue
            if visited[du][dv]:
                continue
            if arr[du][dv] == -2:
                continue
            if arr[du][dv] == 1:
                if dist[du][dv]<rank+1: #이미 다른 곳이 최단거리면 그 쪽은 가지 말기
                    continue
                dist[du][dv] = rank+1
            visited[du][dv] = 1
            q.append([du, dv, rank+1])

#input
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
hospitals = []
people = []
selected = [(0,0)]*m
inf = 50*2*100

dist = [[inf] * n for _ in range(n)]

k=0
answer = inf
#arr에서 병원인 경우 list에 넣기 (뽑을 병원 후보군)
for i in range(n):
    for j in range(n):
        if arr[i][j]==2:
            hospitals.append((i,j))
            k+=1
        elif arr[i][j] == 1:
            people.append((i,j))
#병원 m개 뽑기
pick_hospitals(0, 0)
print(answer)