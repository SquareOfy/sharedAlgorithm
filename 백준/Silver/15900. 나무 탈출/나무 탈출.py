from collections import deque

def bfs():
    global cnt
    visited = [0]*(n+1)
    visited[1] = 1
    q = deque([(1, 0)])

    while q:
        now, rank = q.popleft()
        flag = False
        for node in edges[now]:
            if visited[node]:
                continue

            visited[node] = 1
            q.append((node, rank+1))
            flag = True
        if not flag:
            cnt += rank
n = int(input())
edges = [[] for _ in range(n+1)]

for i in range(n-1):
    st, ed = map(int, input().split())
    edges[st].append(ed)
    edges[ed].append(st)

rank_lst = [0] * (n+1)
cnt = 0
bfs()
print("Yes" if cnt%2==1 else "No")