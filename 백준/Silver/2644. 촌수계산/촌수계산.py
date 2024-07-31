from collections import deque
n = int(input())
s, g = map(int, input().split())

m = int(input())
connected = [[] for _ in range(n+1)]
for i in range(m):
    x, y = map(int, input().split())
    connected[x].append(y)
    connected[y].append(x)

q = deque([[s, 0]])
visited = [0]*(n+1)
visited[s] = 1
answer = -1
while q :
    now = q.popleft()
    num = now[0]
    rank = now[1]
    if num == g:
        answer = rank
        break
    for i in connected[num]:
        if not visited[i]:
            q.append([i, rank+1])
            visited[i] = 1
print(answer)