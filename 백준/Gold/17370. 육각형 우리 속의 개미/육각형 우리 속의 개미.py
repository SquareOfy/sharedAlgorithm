def dfs(level, cur, cr, cc, lst):
    global answer
    if level==n:
        if visited[cr][cc] ==2:
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
visited[4*n+1][3*n] = 1
visited[4*n][3*n] = 1

answer = 0
dfs(0, 0, 4*n, 3*n, [0])
print(answer)