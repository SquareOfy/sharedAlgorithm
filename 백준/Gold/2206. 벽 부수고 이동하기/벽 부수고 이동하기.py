from collections import deque

n, m = map(int, input().split())

arr = [list(map(int, list(input()))) for _ in range(n)]
visited = [[[0] * m for _ in range(n)] for i in range(2)]
q = deque([[0, 0, 0, 1]])
visited[0][0][0] = 1
answer = -1
while q:
    now = q.popleft()
    isbreak = now[2]
    rank = now[3]
    if now[0] == n - 1 and now[1] == m - 1:
        answer = rank
        break

    for d in ((-1, 0), (0, -1), (1, 0), (0, 1)):
        du = now[0] + d[0]
        dv = now[1] + d[1]
        if du < 0 or dv < 0 or du >= n or dv >= m:
            continue
        if visited[isbreak][du][dv] == 0 and arr[du][dv] == 0:
            q.append([du, dv, isbreak, rank+1])
            visited[isbreak][du][dv] = 1
        if isbreak == 0 and arr[du][dv] == 1 and visited[1][du][dv] == 0:
            q.append([du, dv, 1, rank+1])
            visited[1][du][dv] = 1

print(answer)
