n,m,k = map(int, input().split())

def dfs(cnt, selected_sum):
    global answer
    if cnt == k:
        answer = max(answer, selected_sum)
        return

    for i in range(n):
        for j in range(m):
            flag = True
            for d in (-1, 0), (0, -1), (1, 0), (0, 1):
                du = i+d[0]
                dv = j+d[1]
                if du <0 or dv<0 or du>=n or dv>=m:
                    continue
                if visited[du][dv]:
                    flag=False
                    break
            if flag and not visited[i][j]:
                visited[i][j] = 1
                dfs(cnt+1, selected_sum+arr[i][j])
                visited[i][j] = 0

arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]
answer = -10000*n*m
dfs(0, 0)
print(answer)


