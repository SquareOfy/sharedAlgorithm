from collections import deque

n, k = map(int, input().split())

visited = [100002] * 100001

q = deque([[n, 0]])
visited[n] = 0
answer = 100002
while q:
    now = q.popleft()
    rank = now[1]
    if now[0] == k:
        answer = min(rank, answer)

    if now[0] * 2 <= 100000 and visited[now[0] * 2]>rank:
        q.append([now[0] * 2, rank])
        visited[now[0] * 2] = rank
    if now[0] - 1 >= 0 and visited[now[0] - 1]>rank+1:
        q.append([now[0] - 1, rank + 1])
        visited[now[0] - 1] = rank+1
    if now[0] + 1 <= 100000 and visited[now[0] + 1]>rank+1:
        q.append([now[0] + 1, rank + 1])
        visited[now[0] + 1] = rank+1

print(answer if answer < 100002 else 0)
