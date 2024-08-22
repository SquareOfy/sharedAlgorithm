"""
56분 문제 읽기 시작
4시 구상시작 2분 구상완료 ... 너무짧나 ,,
4시 14분 구현완료 및 구상 허점 발견. 디버깅 시작
/ \ 만날때 방향 +1, +3 중 하나로 일관성 있다고 잘못 생각함
디버깅완료 35분

===========구상===========
시작위치에서 상우하좌 순으로 for문 돌려서 시그널 보내보기

시그널 보내기 구현 (함수)
현재 위치, 현재 방향 입력받기

그 위치로 갈 수 있는 방향이 '.'이고 not visited 면 가기
visited면 무한루프 -1 return
oob이거나 'C'이면 return cnt (최댓값 등호 안넣기)

행성이면
'/ ' 이면 좌-상 / 우-하 짝꿍이므로 방향키 + 1 모듈
'\' 이면 +3 모듈


무한히 전파 어떻게 처리?
사이클을 도는 경우이므로 visited 함수 처리를 통해 방문한 곳을 또 방문했다면

Voyager 출력

"""


def oob(i, j):
    if i < 0 or j < 0 or i >= n or j >= m or arr[i][j] == 'C':
        return True
    return False


def send_signal(k):
    r, c = pr, pc
    visited = [[[] for i in range(m)] for _ in range(n)]
    visited[r][c].append(k+1)
    # for i in range(n):
    #     print(visited[i])
    cnt = 1
    d = k
    while 1:
        di, dj = directions[d]
        du = r + di
        dv = c + dj

        if oob(du, dv):
            return cnt
        if d+1 in visited[du][dv]:
            return -1
        if arr[du][dv] == '/':
            if d%2 ==0:
                d = (d + 1) % 4
            else:
                d = (d + 3) % 4

        elif arr[du][dv] == '\\':
            if d % 2 == 1:
                d = (d + 1) % 4
            else:
                d = (d + 3) % 4
        visited[du][dv].append(d + 1)
        cnt += 1
        r = du
        c = dv


n, m = map(int, input().split())
arr = [list(input()) for i in range(n)]
pr, pc = map(int, input().split())
pr-=1
pc-=1
answer = 0
answer_dir = -1
directions = (-1, 0), (0, 1), (1, 0), (0, -1)
d_lst = ['U', 'R', 'D', 'L']
flag = False
for i in range(4):
    tmp = send_signal(i)
    if tmp == -1:
        print(d_lst[i])
        print("Voyager")
        flag = True
        break
    if tmp > answer:
        answer = tmp
        answer_dir = d_lst[i]

if not flag:
    print(answer_dir)
    print(answer)
