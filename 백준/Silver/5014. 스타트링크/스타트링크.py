from collections import deque
f, s, g, u, d = map(int, input().split())

visited = [0]*(f+1)
q = deque([[s, 0]])
visited[s] = 1
answer = 0
flag = False
while q:
    now = q.popleft()
    floor = now[0]
    rank = now[1]

    if floor == g:
        flag = True
        answer = rank
        break

    if floor+u <=f and not visited[floor+u]:
        visited[floor+u] = 1
        q.append([floor+u, rank+1])
    if floor-d >=1 and not visited[floor-d]:
        visited[floor-d] = 1
        q.append([floor-d, rank+1])
if flag:
    print(answer)
else:
    print("use the stairs")