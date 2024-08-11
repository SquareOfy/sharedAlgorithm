from collections import deque
def bfs(r, c):
    global answer
    q = deque([(r,c)])
    visited[r][c] = 1

    while q:
        y, x = q.popleft()
        dir = []
        if y %2 ==0:
            dir = even
        else:
            dir = odd
        for d in dir:
            du = y+d[0]
            dv = x+d[1]

            if du<0 or dv<0 or du>=h+1 or dv>=w+1:
                continue
            if arr[du][dv] == 1:
                answer += 1
                continue
            if arr[du][dv]==0 and not visited[du][dv]:
                q.append((du, dv))
                visited[du][dv] =1


w, h = map(int, input().split())


arr = [[0]*(w+2) for _ in range(h+2)]

for i in range(1, h+1):
    arr[i][1:w+1] = list(map(int, input().split()))

odd = (-1, 0), (-1, 1), (1,0), (1,1), (0, -1), (0, 1)
even = (-1, -1), (-1, 0), (1, -1), (1, 0), (0, -1), (0, 1)
visited = [[0]*(w+2) for _ in range(h+2)]
answer =0

for i in range(w+2):
    if not visited[0][i]:
        bfs(0, i)
    if not visited[h+1][i]:
        bfs(h+1, i)
for i in range(1, h+1):
    if not visited[i][0]:
        bfs(i, 0)
    if not visited[i][w+1]:
        bfs(i, w+1)


print(answer)