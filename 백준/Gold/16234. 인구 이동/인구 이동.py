"""
1501 문제 읽기 시작
1505 문제 이해 완  + 조건정리, 구상 시작
1512 구상 완 구현시작
1600 제출했는데 틀림 + 틀린 테케 이해 안감 문제 다시읽기 시도
1606 문제 안보임 테케 이해불가 ..다른문제 풀고오겟음
1643 다시돌아옴 ^^ ...
1655 아무리 프린트 디버깅을 해도, 테케를 봐도 이상함. 내 로직은 맞음
    그래서 코드 차근차근 꼼꼼히 봤고,, 디버깅하는 과정에서 놔둔 answer==2 이면 break 발견..

==================조건 정리=====================
- n * n 정사각형

- L <= 하나의 선을 맞대고 있는 두 계란틀의 계란의 양의 차이(상하좌우) <=R 이면 선 분리

- 모든 계란틀에 대해 검사를 실시 후 선 분리(계란 합치기)

- 합쳤다 다시 분리한 이후의 각 계란틀별 계란의 양은 (합쳐진 계란의 총 합)//(합쳐진 계란틀의 총 개수) *소수점 버림

-계란 이동 필요없을 때(모든 칸에서 상하좌우의 계란 개수 차이가 L보다 작거나 R보다 큰경우)까지 반복
- 계란 이동횟수 출력

주의할점
매번 상하좌우와 크기 비교 후 바로 2등분 하는게 아님. 최대 영역까지 합칠 틀 영역 파악 후 한번에 계란 분배해야함


====================구상================================

1. 계란 틀 검사하기 (종료 조건을 위해 없어진 선이 있는지 여부 확인해야 함.)
    있다면 어떻게 표기할 것인가. dfs  표기하자
    표기할 배열 준비
    cnt 변수를 두고 양쪽 다 0이면 양쪽 다 cnt 넣고, 한쪽이 0이 아닌 곳이 있으면 그 값으로 배열에 표기해두기
    한번도 선 없앤 적 없으면 while 문 break
2. 표기해놓은 배열을 보며 0이 아니면 bfs or dfs로 그 영역과 연결된 부분의 계란 개수의 합 , 계란 틀의 개수 구해오기
3. 2에서 구한 값을 바탕으로 구한 분배할 계란의 값을 visited가 같은 동작을 돌며 arr 채우기
(2, 3에서 영역 찾아가는게 같으므로 같은 함수로 돌리되, 동작을 달리하게 할 수 있을듯)

merged 배열 선언을 while문 안에 넣어도 될까?
시간복잡도 계산
50*50*2000
"""
import sys
from collections import deque
sys.setrecursionlimit(10000)
def merge():
    cnt = 1

    for i in range(N):
        for j in range(N):
            if merged[i][j]:
                continue
            for di, dj in dir:
                du = i + di
                dv = j + dj
                if 0 <= du < N and 0 <= dv < N:
                    if L <= abs(arr[i][j] - arr[du][dv]) <= R:
                        dfs_merge(i, j, cnt)
                        cnt += 1
                        break
    if cnt == 1:
        return False
    else:
        return True


def dfs_merge(r, c, cnt,):
    merged[r][c] = cnt
    for di, dj in dir:
        du = di + r
        dv = dj + c
        if du < 0 or dv < 0 or du >= N or dv >= N:
            continue
        if merged[du][dv]:
            continue
        if L <= abs(arr[du][dv] - arr[r][c]) <= R:
            dfs_merge(du, dv, cnt)


# 입력
N, L, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

dir = (-1, 0), (0, -1), (1, 0), (0, 1)

answer = 0

#주어진 배열에서 같은 숫자를 가진 값인 상하좌우를 입력값으로 채우는 함수
def find_eggs_value(r, c):
    s = arr[r][c]
    cnt = 1
    q = deque([[r, c]])
    visited[r][c] =1
    while q:
        i, j = q.popleft()
        for di, dj in dir:
            du = i+di
            dv = j+dj
            if du<0 or du>=N or dv<0 or dv>=N:
                continue
            if visited[du][dv]:
                continue
            if merged[i][j]==merged[du][dv]:
                cnt+=1
                s+=arr[du][dv]
                visited[du][dv] = 1
                q.append([du,dv])
    # print(s)
    # print(cnt)
    # print("--- visited ---")
    # for t in range(N):
    #     print(visited[t])

    return s//cnt
def fill_eggs(r, c, k):
    q = deque([[r, c]])
    arr[r][c] = k
    while q:
        i, j = q.popleft()
        for di, dj in dir:
            du = i + di
            dv = j + dj
            if du < 0 or du >= N or dv < 0 or dv >= N:
                continue
            if merged[i][j] == 0:
                continue
            if merged[i][j] == merged[du][dv]:
                arr[du][dv] = k
                q.append([du, dv])
        merged[i][j] = 0

while 1:
    # 계란 틀 깰 수 있는지 검사 및 표기

    # 계란틀 합쳐졌는지 표기하는 배열
    merged = [[0] * N for _ in range(N)]
    flag = merge()
    # print("=====================merge==================")
    # for i in range(N):
    #     print(merged[i])
    # print()
 # for i in range(N):
    #     print(arr[i])`
    if not flag:
        break
    # 계란 틀 깨고 계란 분배할 값 구해서 채우기
    visited = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            #합쳐질 필요 없으면 넘어가

            if not merged[i][j]:
                continue
            #계란 값 구하기

            k = find_eggs_value(i, j)
            # print("==================find======================")
            # print("k : ", k)
            #계란 값으로 채우기
            fill_eggs(i, j, k)
    # print("==================after fill======================")
    # for i in range(N):
    #     print(arr[i])
    # print()
    answer += 1

print(answer)
