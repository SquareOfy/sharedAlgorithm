from collections import deque

def bfs():
    q = deque([])
    visited = [0]*(n+1)
    q.append(v)
    visited[v] = 1

    while len(q) != 0:
        now = q.popleft()
        bfs_answer.append(now)
        for i in connected[now]:
            if not visited[i]:
                visited[i] = 1
                q.append(i)

n, m, v = map(int, input().split())


connected = [[] for _ in range(n+1)]

for i in range(m):
    st, ed = map(int, input().split())
    connected[st].append(ed)
    connected[ed].append(st)
for i in range(n+1):
    connected[i].sort(reverse=True)

stk = [v]
visited = [0]*(n+1)
dfs_answer = []
bfs_answer = []

while stk:
    cur = stk.pop()
    if not visited[cur]:
        visited[cur] = 1
        dfs_answer.append(cur)
        for i in connected[cur]:
            if not visited[i]:
                stk.append(i)

for i in range(n+1):
    connected[i].sort()

bfs()

print(*dfs_answer)

print(*bfs_answer)