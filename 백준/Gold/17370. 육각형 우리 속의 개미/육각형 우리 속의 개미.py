"""\
반시계 기준으로 ! (반대방향은 +5)
0(위로 올라옴) => 1 or 5 타게 됨
1(왼쪽 대각 위) => 2 or 0 타게 됨
2(왼쪽 대각 아래) => 3, 1
3(아래 방향 ) => 4, 2
4(오른쪽 대각 아래) => 5, 3
5 => 0, 4

반대방향은 +3 하기

"""
def dfs(level, cur, cr, cc, lst):
    # print("============================")
    # print("level : ", level)
    # print(cur)
    # print(cr, cc)
    global answer
    if level==n:
        if visited[cr][cc] ==2:
            # # print("================================================")
            # print(lst)
            # if lst == [0, 5, 0, 5, 0, 1]:
            #     for i in range(8*n+1):
            #         print(visited[i])
            # # print()
            # # print("================================================")
            answer+=1
        return
    idx = 1

    for di, dj in dir_dict[cur]:
        du = cr+di
        dv = cc+dj
        if not visited[du][dv] or (visited[du][dv] and level==n-1):
            visited[du][dv] += 1
            dfs(level+1, (cur+idx)%6, du, dv, lst+[(cur+idx)%6])
            visited[du][dv] -= 1
        idx*=-1


n = int(input())

visited = [[0]*(6*n+1) for _ in range(8*n+1)]
dir_dict = {0:[(-1, -1), (-1, 1)], 1: [(1, -1), (-1, 0)], 2: [(1, 0),(-1, -1)], \
            3: [(1, 1),(1, -1) ], 4:[(-1, 1), (1, 0)], 5:[(-1, 0), (1, 1)]}
# visited[8*n+1][6*n] = 1
# visited[8*n][6*n] = 1
visited[4*n+1][3*n] = 1
visited[4*n][3*n] = 1

answer = 0
# dfs(0, 0, 8*n, 6*n, [(8*n, 6*n)])
dfs(0, 0, 4*n, 3*n, [0])
print(answer)