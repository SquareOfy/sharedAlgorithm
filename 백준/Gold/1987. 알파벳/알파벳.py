def oob(i, j):
    return i<0 or j<0 or i>=R or j>=C

def dfs(level, r, c):
    global answer

    move_flag = False
    for di, dj in DIR:
        du = r+di
        dv = c+dj
        if oob(du, dv): continue
        if visited[arr[du][dv]]: continue
        move_flag = True
        visited[arr[du][dv]] = 1
        dfs(level+1, du, dv)
        visited[arr[du][dv]]=0
    if not move_flag:
        answer = max(level, answer)
        return



R, C = map(int, input().split())
arr = [list(input()) for _ in range(R)]
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
visited = [0]*26
A = ord('A')
arr = [list(map(lambda x : ord(x)-A , arr[i])) for i in range(R)]
answer = 0

visited[arr[0][0]] =1
dfs(1, 0, 0)
print(answer)