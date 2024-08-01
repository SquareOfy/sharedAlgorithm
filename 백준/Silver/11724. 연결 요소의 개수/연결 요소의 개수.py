n, m = map(int, input().split())
edges = [[] for i in range(n + 1)]
def dfs(i):
    visited[i] = 1
    for e in edges[i]:
        if not visited[e]:
            dfs(e)

for i in range(m):
    u, v = map(int, input().split())
    edges[u].append(v)
    edges[v].append(u)


visited = [0]*(n+1)
cnt = 0
for i in range(1, n+1):
    if not visited[i]:
        cnt += 1
        dfs(i)
print(cnt)