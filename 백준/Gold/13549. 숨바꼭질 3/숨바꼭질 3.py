def oob(c):
    return c<0 or c>=100001

from collections import deque
N, K = map(int, input().split())

if K<N:
    print(N-K)
else:
    q = deque([(N, 0)])
    visited = [100001]*100001
    visited[N] = 0
    answer = 100001
    while q:
        cur, rank = q.popleft()
        if cur == K:
            answer = min(rank, answer)
            continue
        if not oob(cur*2) and  visited[cur*2]>rank:
            visited[cur*2] = rank
            q.append((cur*2, rank))

        if not oob(cur+1) and visited[cur+1]>rank+1:
            visited[cur+1] = rank+1
            q.append((cur+1, rank+1))

        if not oob(cur-1) and visited[cur-1]>rank+1:
            visited[cur-1] = rank+1
            q.append((cur-1, rank+1))
    print(answer)