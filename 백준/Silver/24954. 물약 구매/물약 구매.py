def dfs(level, price, total):
    global answer
    if level == n:
        answer = min(answer, total)
        return

    for i in range(1, n+1):
        if visited[i]:
            continue
        p = price[:]
        for item, sale in edges[i]:
            p[item] = max(p[item]-sale, 1)
        visited[i]= 1
        dfs(level+1, p, total+p[i])
        visited[i] = 0

n = int(input())
price =[0] + list(map(int, input().split()))
edges = [[] for _ in range(n+1)]
for i in range(1, n+1):
    m = int(input())
    for j in range(m):
        a, d = map(int, input().split())
        edges[i].append((a, d))
visited = [0]*(n+1)
answer = 1000*n
dfs(0, price, 0)
print(answer)