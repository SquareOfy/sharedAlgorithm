from collections import deque

def bfs(k):
    q = deque([(k, 0)])
    visited = [0]*(N+1)
    visited[k] = 1
    friend_cnt = 0
    while q:
        cur, rank = q.popleft()

        for nxt in friends[cur]:
            if visited[nxt]: continue
            visited[nxt] = 1
            friend_cnt += 1
            if friend_cnt == N-1:
                return rank+1
            q.append((nxt, rank+1))


    return -1
N = int(input())
friends = [[] for _ in range(N+1)]
while 1:
    a, b = map(int, input().split())
    if a==-1: break
    friends[a].append(b)
    friends[b].append(a)

depth = [0]*(N+1)

for n in range(1, N+1):
    if len(friends[n]) == N-1:
        depth[n] = 1
        continue
    depth[n] = bfs(n)

mx = min(depth[1:])
cnt = depth[1:].count(mx)
lst = []
for n in range(1, N+1):
    if depth[n]==mx:
        lst.append(n)
print(mx, cnt)
print(*lst)