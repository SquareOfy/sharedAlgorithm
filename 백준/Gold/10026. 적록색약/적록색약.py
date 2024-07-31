import sys
sys.setrecursionlimit(10000)
n = int(input())
arr = [list(input()) for _ in range(n)]

directions = (-1, 0), (0, -1), (1, 0), (0, 1)

visited = [[[0]*n for _ in range(n)] for _ in range(2)] #0은 일반인, 1은 적록색약

def dfs(r, c, ver, cnt):
    visited[ver][r][c] = cnt

    for d in directions:
        du = r+d[0]
        dv = c+d[1]
        if du<0 or dv<0 or du>=n or dv>=n:
            continue
        if ver == 0 and arr[du][dv] == arr[r][c] and not visited[ver][du][dv]:
            dfs(du, dv, ver, cnt)
        elif ver == 1:
            if not visited[ver][du][dv]:
                if arr[r][c] == arr[du][dv] == 'B':
                    dfs(du, dv, ver, cnt)
                elif (arr[r][c] == 'R' or arr[r][c] == 'G') and (arr[du][dv] =='R' or arr[du][dv] == 'G'):
                    dfs(du, dv, ver, cnt)

cnt1 = 1
cnt2 = 1
for i in range(n):
    for j in range(n):
        if not visited[0][i][j]:
            dfs(i, j, 0, cnt1)
            cnt1+=1
        if not visited[1][i][j]:
            dfs(i, j, 1, cnt2)
            cnt2+=1
print(cnt1-1, cnt2-1)