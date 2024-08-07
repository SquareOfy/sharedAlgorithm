board = [list(map(int, input().split())) for _ in range(5)]
r, c = map(int, input().split())
visited = [[0]*5 for _ in range(5)]

flag = 0
def dfs(i, j, apple, step):
    global flag

    if flag:
        return
    if step<=3 and apple >=2:
        flag = 1
        return


    for d in (-1, 0), (0, -1), (1, 0), (0, 1):
        du = i+d[0]
        dv = j+d[1]
        if du<0 or dv<0 or du>=5 or dv>=5:
            continue

        if board[du][dv] == -1 or visited[du][dv]:
            continue

        if board[du][dv] == 1:
            visited[i][j] = 1
            dfs(du, dv, apple+1, step+1)
            visited[i][j] = 0
        else:
            visited[i][j] = 1
            dfs(du, dv, apple, step+1)
            visited[i][j] = 0


dfs(r, c, 0, 0)
print(flag)