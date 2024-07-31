from collections import deque
n, k = map(int, input().split())

visited = [0]*100001

q = deque([[n, 0]])
visited[n] = 0
answer = 0
while q:
    now = q.popleft()
    rank = now[1]
    if now[0] == k:
        answer = rank
        break
    if now[0]-1 >= 0 and not visited[now[0]-1]:
        q.append([now[0]-1, rank+1])
        visited[now[0]-1] = 1
    if now[0] + 1 <=100000 and not visited[now[0]+1]:
        q.append([now[0]+1, rank+1])
        visited[now[0]+1] =1
    if now[0]*2 <= 100000 and not visited[now[0]*2]:
        q.append([now[0]*2, rank+1])
        visited[now[0]*2] = 1
print(answer)


