"""
1. SIDE 돌면서 START POINT 잡기
2. 초기 열쇠 key_lst에 체크해두기
3. start_point_lst 부터 bfs 돌기
    알파벳 대문자 door_lst에 정리하고 만약 이미 key가 있으면 visited체크 '.'으로 바꾸기
    알파벳 소문자 만나면 key_lst에 체크해주고 지금까지 모인 door_lst 돌면서
        - visited 체크, '.'으로 바꿔주기(굳이?) , queue 에 넣어주기
    $ 만나면 answer +1

"""

from collections import deque


def set_start_point_lst():
    for i in range(1, N):
        o = ord(arr[i][M-1])
        if big_a<= o < big_a+26:
            if key_lst[o-big_a]:
                arr[i][M-1] = '.'
            else:
                door_lst[o-big_a].append((i, M-1))
                continue
        elif small_a <= o < small_a + 26:
            key_lst[o - small_a] = 1
        if arr[i][M - 1] != '*':
            start_point_lst.append((i, M - 1))
    for i in range(1, M):
        o = ord(arr[0][i])
        if big_a <= o < big_a + 26:
            if key_lst[o - big_a]:
                arr[0][i] = '.'
            else:
                door_lst[o-big_a].append((0, i))

                continue
        elif small_a <= o < small_a + 26:
            key_lst[o - small_a] = 1
        if arr[0][i] != '*':
            start_point_lst.append((0, i))
    for i in range(M - 2, -1, -1):
        o = ord(arr[N-1][i])
        if big_a <= o < big_a + 26:
            if key_lst[o - big_a]:
                arr[N-1][i] = '.'
            else:
                door_lst[o-big_a].append((N-1, i))
                continue
        elif small_a <= o < small_a + 26:
            key_lst[o - small_a] = 1
        if arr[N-1][i] != '*':
            start_point_lst.append((N-1, i))

    for i in range(N - 2, -1, -1):
        o = ord(arr[i][0])
        if big_a <= o < big_a + 26:
            if key_lst[o - big_a]:
                arr[i][0] = '.'
            else:
                door_lst[o-big_a].append((i, 0))
                continue
        elif small_a <= o < small_a + 26:
            key_lst[o - small_a] = 1
        if arr[i][0] != '*':
            start_point_lst.append((i, 0))

        if arr[i][0] == '.':
            start_point_lst.append((i, 0))


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= M


def bfs(r, c):
    global answer
    q = deque([(r, c)])
    visited[r][c] = 1

    while q:
        cr, cc = q.popleft()
        if arr[cr][cc] == '$':
            answer += 1
        for di, dj in DIR:
            du, dv = cr + di, cc + dj
            if oob(du, dv): continue
            if visited[du][dv] or arr[du][dv] == '*': continue

            o = ord(arr[du][dv])

            # 알파벳 대문자 door_lst에 정리하고 만약 이미 key가 있으면 visited체크 '.'으로 바꾸기
            if big_a <= o < big_a + 26:
                no = o - big_a
                if key_lst[no]:  # 열쇠 있으면 그냥 가보기
                    arr[du][dv] = '.'
                    visited[du][dv] = 1
                    q.append((du, dv))
                else:  # 열쇠 없으면 door 목록에 저장해두기
                    door_lst[no].append((du, dv))
            # 알파벳 소문자 만나면 key_lst에 체크해주고 지금까지 모인 door_lst 돌면서
            elif small_a <= o < small_a + 26:
                key_lst[o - small_a] = 1
                q.append((du, dv))
                visited[du][dv] = 1
                for nr, nc in door_lst[o - small_a]:
                    visited[nr][nc] = 1
                    arr[nr][nc] = '.'
                    q.append((nr, nc))
            else:
                q.append((du, dv))
                visited[du][dv] = 1

            #         - visited 체크, '.'으로 바꿔주기(굳이?) , queue 에 넣어주기
            #     $ 만나면 answer +1


# 입력 받기
T = int(input())
small_a = ord('a')
big_a = ord('A')
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
# start_point_lst
for t in range(T):
    N, M = map(int, input().split())
    arr = [list(input()) for _ in range(N)]
    answer = 0
    start_point_lst = []
    key_lst = [0] * 26
    door_lst = [[] for _ in range(26)]

    keys = input()

    # 초기 소유 키 세팅
    for k in keys:
        if k == '0':
            break
        key_lst[ord(k) - small_a] = 1
    # print(key_lst)
    # start_point_lst 세팅
    set_start_point_lst()
    # for i in range(N):
    #     print(arr[i])
    visited = [[0] * M for _ in range(N)]

    for r, c in start_point_lst:
        if visited[r][c]: continue
        bfs(r, c)


    # 마지막 lst 털기!!
    for i in range(26):
        if key_lst[i] and door_lst[i]:
            for r, c in door_lst[i]:
                if not visited[r][c]:
                    bfs(r,c)
    print(answer)