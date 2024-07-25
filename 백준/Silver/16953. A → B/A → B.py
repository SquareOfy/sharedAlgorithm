from collections import deque

a, b = map(int, input().split())

answer = -1

q = deque([[a,0]])
# visited = [0]*(b+1)

while len(q) != 0:
    now = q.popleft()
    if now[0] == b:
        answer = now[1]+1
        break
    if now[0] * 2 <= b :
        # visited[now[0]*2] = 1
        q.append([now[0] * 2, now[1] + 1])
    if now[0] * 10 + 1 <= b :
        # visited[now[0] * 10 + 1] = 1
        q.append([now[0] * 10 + 1, now[1] + 1])

print(answer)