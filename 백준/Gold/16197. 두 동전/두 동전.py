def dfs(level, c1, c2):
    global answer
    if answer <= level:
        return
    if level==11:
        return

    for d in dir:
        flag1, flag2 = False, False
        cc1, cc2 = c1.copy(), c2.copy()
        #동전 1
        nc1 = [cc1[0]+d[0], cc1[1]+d[1]]
        # 보드 바깥이면 flag 변경
        if nc1[0] < 0 or nc1[1] < 0 or nc1[0] >= n or nc1[1] >= m:
            flag1 = True
        #.이면 움직여
        elif board[nc1[0]][nc1[1]] == '.':
            cc1=nc1.copy()


        nc2 = [cc2[0]+d[0], cc2[1]+d[1]]
        # .이면 움직여
        if nc2[0] < 0 or nc2[1] < 0 or nc2[0] >= n or nc2[1] >= m:
            flag2 = True
        elif board[nc2[0]][nc2[1]] == '.':
            cc2 = nc2.copy()
        # 보드 바깥이면 flag 변경

        if flag1 and flag2:
            continue
        if flag1 or flag2:
            answer = min(answer, level+1)
            return
        if cc1 == c1 and cc2 == c2:
            continue
        dfs(level+1, cc1, cc2)


n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]
dir = (0, -1), (0, 1), (-1, 0), (1, 0)
coin1 = [-1, -1]
coin2 = [-1, -1]
answer = 11
for i in range(n):
    for j in range(m):
        if board[i][j] == 'o':
            if coin1[0]==-1:
                coin1 = [i, j]
            else:
                coin2 = [i, j]
            board[i][j] = '.'

dfs(0, coin1, coin2)
print(answer if answer<=10 else -1)