
"""
1533 문제 이해 완 + 대략 구상 완료 ( 백트래킹 사용할 것)
1554 구현 완료 코드트리 제출했지만 시간초과 ...
1614 백트래킹완료 후 최단거리 계산하는 방식 병원 위주로 코드 변경 후 제출

1614 백준 문제 파악 시작
1618 치킨집으로부터 집과의 최단거리 배열 갱신하는 부분에서 continue 추가함 => 정답

==============================================================================
초기 제출 : 시간이 매우 몹시 많이 들었다. 아무래도 한집배달 아니고 알뜰배달인듯 ..! 개선해보자!
메모리 : 151048KB
시간 : 2268ms

개선 시도 1회차
난 왜 굳이 bfs를 했는가....
수학 전공을 다시 좀 붙잡아보자 ...
그냥 계산하면 될 걸 다 컴퓨터한테 돌리지 말자 ㅠ



=================================== 구상 =====================================

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
        tmp = 0
        for p in people:
            d = inf
            for h in selected:
                d = min(get_distance(p, h), d)
            tmp += d
        answer = min(tmp, answer)

        answer = min(answer, tmp)
        return

    for i in range(idx, k):
        h = hospitals[i]
        selected[level] = h
        pick_hospitals(level+1, i+1)


def get_distance(a,b):
    return abs(a[0]-b[0])+abs(a[1]-b[1])

#input
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
hospitals = []
people = []
selected = [(0,0)]*m
inf = 50*2*100


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