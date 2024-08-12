"""
. : 빈칸
o : 핀이 꽂혀있는 칸
# : 구멍이 없는 칸
핀 최대 8개
핀은 상하좌우로 인접한 핀을 뛰어넘어 다음 빈칸으로 이동하는 것만 허용
인접한 핀은 제거됨

핀을 움직여서 남길 수 있는 핀의 최소개수 & 그 개수를 만들기 위해 필요한 최소 이동횟수


#모든 판을 탐색하면서 o이고 상하좌우에 있고, 반대편이 구멍이 있는 곳이면 뛰어넘어보기 ?
핀이 없어진 경우를 어떻게 처리할 것인가.
기존 arr는 건들면 안됨 .
"""


def get_possible_move():
    result = []
    for i in range(5):
        for j in range(9):
            if arr[i][j] == 'o':
                for d in directions:
                    du = i + d[0]
                    dv = j + d[1]
                    jump_du = du + d[0]
                    jump_dv = dv + d[1]
                    if jump_du < 0 or jump_dv < 0 or jump_du >= 5 or jump_dv >= 9:
                        continue
                    if arr[jump_du][jump_dv] != '.':
                        continue
                    if arr[du][dv] != 'o':
                        continue
                    result.append([i, j, 1])
                    break
    return result


def dfs(move):
    global min_move, remain

    pin_lst = get_possible_move()

    if not pin_lst:
        tmp = 0
        for i in range(5):
            for j in range(9):
                if arr[i][j] == 'o':
                    tmp += 1
        if remain > tmp:
            remain = tmp
            min_move = move
        elif remain==tmp:
            min_move = min(move, min_move)
        return

    for pin in pin_lst:
        # if pin[2] == 0:
        #     continue
        r = pin[0]
        c = pin[1]
        for d in directions:
            du = r + d[0]
            dv = c + d[1]
            jump_du = du + d[0]
            jump_dv = dv + d[1]

            if jump_du < 0 or jump_dv < 0 or jump_du >= 5 or jump_dv >= 9:
                continue
            if arr[jump_du][jump_dv] != '.':
                continue
            if arr[du][dv] != 'o':
                continue
            # 핀 옮길 수 있으면 옮겨보기
            arr[r][c] = '.'
            arr[du][dv] = '.'
            arr[jump_du][jump_dv] = 'o'
            # pin_lst 변경
            dfs(move + 1)
            arr[r][c] = 'o'
            arr[du][dv] = 'o'
            arr[jump_du][jump_dv] = '.'


t = int(input())
directions = (-1, 0), (0, -1), (1, 0), (0, 1)
for tc in range(t):
    arr = [list(input()) for _ in range(5)]
    if tc != t - 1:
        input()

    min_move = 100 * 100
    remain = 100*100+1
    dfs(0)

    print(remain, min_move)

