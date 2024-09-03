"""

1534 문제읽기 시작
1538 문제 이해했으나 구현 방법 바로 안떠오름 ㅠ
1547 구상 완료
1622 구현은 완료했는데 index error .... 디버깅 해보자 ,,
        R이 자꾸 #의 위치로 이동함(R이 TMP상에서 사라지는 문제 발생 ;)
1633 B가 이동하려다가 R을 만나서 R을 먼저 이동시킬 때 B가 R을 삼키는 것 같다 ,, R 사라짐
1718 테케 다 맞고 .. 만든 테케도 다 맞는데 뭐가 문제인지 모르겠음
        답이 10일 때가 문제일까 ...?
        10 11 인 경우 해봤는데 이것도 맞음 ㅠㅠ
10 10
##########
###...####
#R..#...##
#######.##
#####...##
#.###.####
#.#...##.#
###.#..###
#B#.##O.##
##########

#answer 10

10 10
##########
#R#...####
#...#...##
#######.##
#####...##
#.###.####
#.#...##.#
###.#..###
#B#.##O.##
##########
ans -1


1743 진심 뭐가 문젠지 모르겠다 ^^^^^^^^^^^^^^^^^^^^^^^^^ 화남. ..

=================구상 ================
1. 구슬 움직인 횟수와 움직임 방향 정하기 => 백트 with dfs 활용
    level이 움직인 횟수
    level == 10 일 때 상태로 -1 출력 여부 판정
    (answer = inf 로 해두고 최종 출력 때 -1할것. 최솟값 찾아야하므로)

    구슬 움직일 수 있는지 확인하고 없으면 return

    한번이라도 answer 갱신된 적 있으면 -1 출력 안하고 바로 return 되도록 하기
2. 구슬 이동 구현
    주어진 방향 따라 B 움직이기
        벽 만나면 STOP
        R 만나면 R 움직이고 B 마저 움직이기 (R움직였다는 flag 변환)
        구멍 만나면 flag_B 변환
    R움직인 적 없으면 R 움직이기
        벽이나 B 만나면 STOP
        구멍 만나면 flag_A 변환
    flag_B True면 0 (불가능)
    flag_A True면 1 (정답 갱신하기)
    둘 다 아니면 다음 dfs 호출   return -1

"""


def dfs(level, arr):
    global answer
    if answer <= level:
        return
    # 구술 한번이라도 움직일 수 있는지 확인. 없으면 return

    # 종료 조건
    if level == 11:
        return
    for d in (-1, 0), (0, -1), (1, 0), (0, 1):
        tmp = [arr[i][:] for i in range(N)]  # 복사해서 움직여보자
        # print(d, level, answer)
        result = move(d, tmp)
        # print("=====move 이후 ======")
        # for k in range(N):
        #     print(tmp[k])
        if result == 0:  # b 빠짐
            continue
        elif result == 1:  # r이 먼저 빠짐
            # print("============answer 갱신 ===========")
            answer = min(answer, level)
            return
        elif result == -2:  # 아무 움직임 없음
            continue
        else:

            dfs(level + 1, tmp)


def move(d, arr):
    flag_R = False
    move_R = False
    blue_move = False
    red_move = False
    rr, rc = -1, -1
    br, bc = -1, -1
    # 구슬 위치 찾기
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 'R':
                rr, rc = i, j
            elif arr[i][j] == 'B':
                br, bc = i, j
    du, dv = br, bc
    # 파란 구슬 이동시키기 d방향으로
    while 1:
        du += d[0]
        dv += d[1]
        if arr[du][dv] == '#':
            du -= d[0]
            dv -= d[1]
            break
        if arr[du][dv] == 'O':
            return 0
        # 빨간 구슬이면 빨간 구슬 부터 다 이동시키고 마저 이동해
        if arr[du][dv] == 'R':
            if move_R:
                du -= d[0]
                dv -= d[1]
                break
            move_R = True
            hole = move_red(d, rr, rc, arr)
            if hole == 1:
                flag_R = True
            else:
                du -= d[0]
                dv -= d[1]
            if hole != 0:
                red_move = True

    # 파란구슬 이동
    if br != du or bc != dv:
        arr[br][bc] = '.'
        arr[du][dv] = 'B'
        blue_move = True
    if not move_R:
        hole = move_red(d, rr, rc, arr)
        if hole == 1:
            flag_R = True
        if hole != 0:
            red_move = True
    
    if flag_R:
        return 1
    if not red_move and not blue_move:
        return -2
    return -1


def move_red(d, rr, rc, arr):
    di = rr
    dj = rc

    while 1:
        di += d[0]
        dj += d[1]
        # print(du, dv)
        if arr[di][dj] == '#' or arr[di][dj] == 'B':
            di -= d[0]
            dj -= d[1]
            break
        if arr[di][dj] == 'O':
            arr[rr][rc] = '.'
            return 1
    arr[rr][rc] = '.'
    arr[di][dj] = 'R'

    if rr == di and rc == dj:
        return 0  # 움직임 없음
    return -1  # 움직이긴 함 . 구멍 x


N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]
inf = 11
answer = inf
dfs(1, board)
print(answer if answer != inf else -1)
