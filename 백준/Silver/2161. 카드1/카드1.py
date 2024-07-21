from collections import deque

n = int(input())
q = deque([i for i in range(1, n+1)])
answer = []
while len(q)>1:
    answer.append(q.popleft())
    q.rotate(-1)


answer.append(q.popleft())
print(*answer)