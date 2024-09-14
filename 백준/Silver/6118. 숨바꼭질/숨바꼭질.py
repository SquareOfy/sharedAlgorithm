from collections import deque

def bfs():
    visited = [0]*(n+1)
    visited[1] = 1
    q = deque([(1, 0)])

    while q:
        now, rank = q.popleft()
        dist[now] = rank
        for nn in edges[now]:
            if visited[nn]:
                continue
            visited[nn] = 1
            q.append((nn, rank+1))

n, m = map(int, input().split())

edges = [[] for _ in range(n+1)]
dist = [0]*(n+1)
for i in range(m):
    st, ed = map(int, input().split())
    edges[st].append(ed)
    edges[ed].append(st)

bfs()
mx = max(dist)
print(dist.index(mx), mx, dist.count(mx))