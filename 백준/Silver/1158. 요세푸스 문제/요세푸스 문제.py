from collections import deque

n, k = map(int, input().split())
q = deque([i for i in range(1,n+1)])
answer = []
while len(q) > 0:
    for i in range(k-1):
        q.rotate(-1)
    answer.append(q.popleft())


print("<", end = "")
print(*answer, end="", sep = ", ")
print(">")