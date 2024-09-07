from collections import deque

def bfs(i):
    visited[i] = 1
    q = deque([(i, 1)])

    while q:
        cur, rank = q.popleft()

        if cur-1>=0 and visited[cur-1]>rank:
            q.append((cur-1, rank+1))
            visited[cur-1] = rank
        if cur+1<=n and visited[cur+1]>rank:
            q.append((cur+1, rank+1))
            visited[cur+1] = rank

        for next in edges[cur]:
            if visited[next]>rank:
                visited[next] = rank
                q.append((next, rank+1))

n, m = map(int, input().split())
s, e = map(int, input().split())
#s에서 e로 갈거임

#n까지 있고 x+1, x-1 갈 수 있고 1초 소요
#m개의 텔레포트 연결
edges = [[] for _ in range(n+1)]
for i in range(m):
    x, y = map(int, input().split())
    edges[x].append(y)
    edges[y].append(x)

visited = [n+1] * (n+1)

bfs(s)
print(visited[e])