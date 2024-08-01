from collections import deque
import sys
sys.setrecursionlimit(10000)

def dfs(i):
    visited[i] = 1
    dfs_answer.append(i)

    for k in edges[i]:
        if not visited[k]:
            dfs(k)
def bfs():
    q = deque([v])
    visited = [0]*(n+1)
    visited[v] = 1

    while q:
        now = q.popleft()
        bfs_answer.append(now)

        for k in edges[now]:
            if not visited[k]:
                visited[k] = 1
                q.append(k)


n, m, v = map(int, input().split())
edges = [[] for _ in range(n+1)]
for i in range(m):
    st, ed = map(int, input().split())
    edges[st].append(ed)
    edges[ed].append(st)
for i in range(n+1):
    edges[i].sort()

dfs_answer = []
bfs_answer = []
visited = [0]*(n+1)
dfs(v)
bfs()
print(*dfs_answer)
print(*bfs_answer)