n, m = map(int, input().split())
lst = list(map(int, input().split()))

lst.sort()

def dfs(cnt,  selected):
    if cnt == m:
        print(*selected)
        return

    for i in range(0, n):
        if visited[i]:
            continue

        visited[i] = 1
        dfs(cnt+1, selected+[lst[i]])
        visited[i] = 0

visited = [0] * n
dfs(0, [])