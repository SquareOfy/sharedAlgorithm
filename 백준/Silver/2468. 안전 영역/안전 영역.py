from collections import deque


n = int(input())
arr = []
h = 0
dir = ((-1, 0), (0, -1), (1, 0), (0, 1))


for i in range(n):
    arr.append(list(map(int, input().split())))
    h = max(h, max(arr[i]))

def bfs(r, c, i):
    q = deque([[r,c]])

    while len(q) !=0 :
        now = q.popleft()

        for d in dir:
            du = now[0] + d[0]
            dv = now[1] + d[1]

            if du<0 or dv <0 or du>=n or dv>=n:
                continue
            if arr[du][dv] > i and visited[du][dv] == 0:
                visited[du][dv] = 1
                q.append([du, dv])

answer = 0

for i in range(h+1):
    tmp = 0
    visited = [[0] * n for _ in range(n)]
    for r in range(n):
        for c in range(n):
            if arr[r][c] > i and visited[r][c] == 0:
                bfs(r, c, i)
                tmp += 1
    answer = max(tmp, answer)


print(answer)

