"""
뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다
뱀은 처음에 오른쪽을 향한다

뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
    몸길이는 변하지 않는다.

꼬리의 방향을 모르므로 몸인 부분 전체를 저장해둬야한다 .
deque 사용 ?
[(머리), (중간1), ... (중간..) , (꼬리)]
=> 사과 있으면 새로운 머리를 맨 앞에 끼워넣어준다
=> 사과 없으면 새로운 머리 맨 앞 끼워넣고 + 꼬리 끝에 하나 없앤다.

# 몸 옮길 때마다 배열에 표시하자 ! ? 아니면 (좌표) in deque로 확인하기 ..


now = 현재시간
for x, d 방향 변환정보 :

    ###############여기 함수화##################
    while now < x: #현재 방향 변환 정보의 시간과 일치할 때까지
        현재 머리 위치
        hr, hc = q[0]
        hr += di
        hc += dj
        now +=1
        #oob 체크. 몸 체크
            return False
        배열에 몸 체크
        사과 있으면 continue
        사과 없으면 꼬리 삭제 q.pop()

    # x초가 됐다 !
    # 방향 전환하기
    if d == L:
        d= (d-1)%4
    else:
        d= (d+1)%4
"""
from collections import deque
def oob(i, j):
    return i<0 or j<0 or i>=N or j>=N
def move(x):
    global now, flag
    #x초까지 움직이기
    di, dj = dir[d]
    while now < x:
        hr, hc = q[0]
        hr += di
        hc += dj
        now += 1
        if oob(hr, hc) or arr[hr][hc]==1:
            return False

        if arr[hr][hc] != -1:
            tr, tc = q.pop()
            # print(tr, tc)
            arr[tr][tc]  = 0

        q.appendleft((hr, hc))
        arr[hr][hc] = 1

    return True

dir = (0, 1), (1, 0), (0, -1), (-1, 0)
N = int(input())
K = int(input())

arr = [[0]*N for _ in range(N)]
for i in range(K):
    r, c = map(int, input().split())
    arr[r-1][c-1] = -1

L = int(input())
change = [list(input().split()) for _ in range(L)]
now = 0
q = deque([(0, 0)])
d = 0
flag = True
for x, change_d in change:
    x = int(x)
    if not move(x):
        flag = False
        break

    if change_d == 'L':
        d = (d-1)%4
    else:
        d = (d+1)%4
di, dj = dir[d]
while flag:
    hr, hc = q[0]
    hr += di
    hc += dj
    now += 1
    if oob(hr, hc) or arr[hr][hc] == 1:
        break
    if arr[hr][hc] != -1:
        tr, tc = q.pop()
        # print(tr, tc)
        arr[tr][tc] = 0

    q.appendleft((hr, hc))
    arr[hr][hc] = 1

print(now)
