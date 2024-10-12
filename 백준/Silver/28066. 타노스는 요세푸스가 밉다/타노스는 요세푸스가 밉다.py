from collections import deque


N, K = map(int, input().split())
lst = [i for i in range(1, N+1)]
q = deque(lst)
pointer = 0
while len(q)>1:
    if len(q)-1<K:
        break
    q.rotate(-1)
    for i in range(K-1):
        q.popleft()

print(q[0])