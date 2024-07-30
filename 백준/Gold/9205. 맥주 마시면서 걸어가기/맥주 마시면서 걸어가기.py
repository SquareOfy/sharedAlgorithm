from collections import deque
t = int(input())

for tc in range(t):
    n = int(input())
    q = deque([])
    visited = [0] *(n+2)
    points = [list(map(int, input().split())) for _ in range(n+2)]

    answer = "sad"

    q.append(0)
    visited[0] = 1
    while len(q)>0:
        now = q.popleft()
        if now == n+1:
            answer = "happy"
            break
        for i in range(n+2):
            if visited[i] == 0:
                dist = abs(points[i][0]-points[now][0]) + abs(points[i][1]-points[now][1])
                if dist > 1000:
                    continue
                visited[i] = 1
                q.append(i)

    print(answer)