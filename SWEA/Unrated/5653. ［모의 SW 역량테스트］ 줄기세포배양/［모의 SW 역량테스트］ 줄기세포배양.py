"""
배양 용기의 크기는 무한하다고 가정
K시간 후 살아있는 줄기 세포(비활성 상태 + 활성 상태)의 총 개수를 구하는 프로그램

줄기 세포들은 비활성 상태
생명력 수치가 X인 줄기 세포의 경우 X시간 동안 비활성 상태
X시간이 지나는 순간 활성 상태
X시간 동안 살아있을 수 있으며 X시간이 지나면 세포는 죽게 된다.
죽은 상태로 해당 그리드 셀을 차지

첫 1시간 동안 상, 하, 좌, 우 네 방향으로 동시에 번식
번식된 줄기 세포는 비활성 상태
번식하는 방향에 이미 줄기 세포가 존재하는 경우 해당 방향으로 추가적으로 번식하지 않는다.

두 개 이상의 줄기 세포가 하나의 그리드 셀에 동시 번식하려고 하는 경우
생명력 수치가 높은 줄기 세포가 해당 그리드 셀을 혼자서 차지
"""
from collections import deque

def oob(i, j):
    return i<0 or j<0 or i>=N+2*K or j>=M+2*K

def printa(string, arr):
    print(f"============{string}==============")
    for i in range(len(arr)):
        print(arr[i])
    print('=====================================')
    print()

T = int(input())
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)

for t in range(1, T+1):
    N, M, K = map(int, input().split())
    arr = [[0]*(M+2*K) for _ in range(N+2*K)] #생명력 기록  / 죽은건 음수
    visited = [[0]*(M+2*K) for _ in range(N+2*K)] #시간 기록
    alive_q = deque([[] for _ in range(11)])
    die_q = deque([[] for _ in range(11)])
    answer = 0
    for i in range(K, K+N):

        lst = list(map(int, input().split()))
        for j in range(M):
            arr[i][j+K] = lst[j]
            if lst[j] != 0:
                alive_q[lst[j]].append((i, j+K, lst[j]))
                visited[i][j+K] = -1
                answer += 1

    for k in range(1, K+1):
        alive_lst = alive_q.popleft()
        alive_q.append([])

        lst = []
        for r, c, v in alive_lst:
            for di, dj in DIR:
                du, dv = r+di, c+dj
                #oob체크 불필요;

                if visited[du][dv] != 0 and visited[du][dv]<k: continue #이미 다른 애가 먼저 차지
                if arr[du][dv]<0: continue
                if arr[du][dv] < v:
                    visited[du][dv] = k
                    arr[du][dv] = v
                    lst.append((du, dv, v))
                    arr[du][dv] = v
            #v-1이 0이면 이제 쥬금 ! 아니면 die_q에 넣어두기
            if v-1==0:
                answer-=1
                arr[r][c] = -v
            else:
                die_q[v-1].append((r, c))


        #번식한 애들 목록
        for r, c, v in lst:
            if arr[r][c] != v:
                continue
            alive_q[v].append((r, c, v))
            answer += 1

        die_lst = die_q.popleft()
        die_q.append([])
        for r, c in die_lst:
            arr[r][c] *= -1
            answer-=1

    print(f"#{t} {answer}")
