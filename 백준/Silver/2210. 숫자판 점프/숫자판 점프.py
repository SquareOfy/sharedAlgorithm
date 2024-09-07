def dfs(level, i, j, num):
    if level==5:
        s.add(num)
        return
    for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
        ni, nj = di+i, dj+j
        if ni<0 or nj<0 or ni>=5 or nj>=5:
            continue
        dfs(level+1, ni, nj, num+arr[ni][nj])


s = set()
arr = [input().split() for _ in range(5)]
# visited = [[0]*5 for _ in range(5)]
for i in range(5):
    for j in range(5):
        dfs(0, i, j, arr[i][j])

print(len(s))