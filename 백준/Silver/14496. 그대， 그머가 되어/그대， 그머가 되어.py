from collections import deque

def bfs(i):
    visited[i] = 1
    q = deque([(i, 0)])

    while q:
        k, rank = q.popleft()
        if k == b:
            return rank
        for e in edges[k]:
            if not visited[e]:
                visited[e] = 1
                q.append((e, rank+1))
    return -1


a, b = map(int, input().split())
n, m = map(int, input().split())

edges = [[] for _ in range(n+1)]
for i in range(m):
    x, y = map(int, input().split())
    edges[x].append(y)
    edges[y].append(x)

answer = -1
visited = [0]*(n+1)
print(bfs(a))