from collections import deque


def bfs(s):
    q = deque([(s, 0)])
    visited = [0] * (N + 1)
    visited[s] = 1
    while q:
        # q에서 cur뽑아서 최단거리가 K면 answer에 추가
        cur, rank = q.popleft()
        if rank == K:
            answer.append(cur)
            continue
        for e in edges[cur]:
            # visited체크하고 q에 다음 연결된 노드 넣기(거리 +1)
            if not visited[e]:
                visited[e] = 1
                q.append((e, rank + 1))


N, M, K, X = map(int, input().split())

edges = [[] for i in range(N + 1)]
# 단방향
for i in range(M):
    st, ed = map(int, input().split())
    edges[st].append(ed)

answer = []
bfs(X)
if answer:
    answer.sort()
    print(*answer, sep='\n')
else:
    print(-1)