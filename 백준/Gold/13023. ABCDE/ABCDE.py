n, m = map(int, input().split())
edges = [[] for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)

answer = 0

def dfs(node, cnt):
    global answer
    if answer:
        return
    if cnt == 4:
        answer = 1
        return

    for f in edges[node]:
        if visited[f]:
            continue
        visited[f] = 1
        dfs(f, cnt+1)
        visited[f] = 0

for i in range(n):
    if answer:
        continue
    visited = [0] * (n + 1)
    visited[i] = 1
    dfs(i, 0)
print(answer)

