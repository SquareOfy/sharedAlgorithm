from collections import deque
n, m = map(int, input().split())

# answer = [[0]*n for _ in range(n)]
visited = [[0]*(n+1) for _ in range(n+1)]
min_sum = n*n+1
answer = 0
friends = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    if not b in friends[a]:
        friends[a].append(b)
        friends[b].append(a)

for i in range(1, n+1):
    q = deque([[i, 0]])
    visited[i][i] = -1

    while q :
        now = q.popleft()
        step = now[1]

        for j in friends[now[0]]:
            if visited[i][j] ==0:
                q.append([j, step+1])
                visited[i][j] = step+1

    if min_sum > sum(visited[i])+1:
        min_sum = sum(visited[i])+1
        answer = i


print(answer)