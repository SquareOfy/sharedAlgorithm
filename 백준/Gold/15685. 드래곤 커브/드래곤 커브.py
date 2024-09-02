"""
26일 목요일 기록
1501 문제읽기 시작 : 딱봐도 어려움. 그리고 헤맸던 기억 나서 다음 문제로 넘어가보기1

9월 2일 월요일 기록
1635 문제 읽기 시작
1646 문제 이해 완료 및 커브 찍는 방법 외 다른 구상 완료 ( 커브 찍는 방법 고민)
1650 커브 관련 구상완료 및 구현 시작


============== 커브 idea ==============
드래곤 커브 범위 밖으로 안나가므로 범위 체크 불필요
1. 끝점 기억하기
2. 끝점 제외 stk에 넣고 꺼내면서 끝점에 연결해가기. .. ?
    끝점 : (ey, ex) / stk에서 꺼낸 점 : (cy, cx)
    방향은 (ex-cx, ey-cy)로 ! 거리는 항상 1. 앞세대는 앞에서 찍었음 !!
    즉 다음에 찍을 점은 (ey + (ex-cx), ex+(ey-cy))
3. stk이 비었다면 마지막 점을 끝점으로 갱신하고 다음 세대로 가기

처음 stk 세팅 및 끝점 세팅 어떻게 할까?
0세대 찍고 그 때 끝점 세팅해놓기

"""
arr = [[0]*101 for _ in range(101)]
dir = (0, 1), (-1, 0), (0, -1), (1, 0)
t= int(input())

for tc in range(t):
    x, y, d, g = map(int, input().split())
    #0세대 찍기
    arr[y][x] = 1
    di, dj = dir[d]
    arr[y+di][x+dj] = 1
    ey, ex = y+di, x+dj
    stk = [(y, x), (ey, ex)]
    ng = 0
    r = 1
    next_stk = []

    while ng<g:
        # print(f"======{ng}세대=======")
        # for i in range(101):
        #     print(arr[i])
        # next_stk.append((ey, ex))
        # print("현재의 ey, ex")
        # print(ey, ex)
        ey, ex = stk[-1]
        # print("ey, ex : ", ey, ex)
        # print(stk)
        for i in range(len(stk)-1, -1, -1):
            ey, ex = stk[-1]
            cy, cx = stk[i]
            # print(cy, cx)
            ny = ey-(ex-cx)
            nx = ex+(ey-cy)
            # print("ny, nx" , ny, nx)
            arr[ny][nx] = 1

            next_stk.append((ny, nx))
        stk.extend(next_stk)
        next_stk = []

        ng+=1
    # print(f"======{ng}세대=======")
    # for i in range(101):
    #     print(arr[i])

answer =0
#answer 찾기
for i in range(100):
    for j in range(100):
        #이 점에서 우, 하, 우하, 본인 체크
        if not arr[i][j] or not arr[i+1][j] or not arr[i][j+1] or not arr[i+1][j+1]:
            continue
        answer+=1
print(answer)