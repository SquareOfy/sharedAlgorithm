from collections import deque

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
answer = "Hing"
q = deque([(0, 0)])
while q:
    now = q.popleft()
    if arr[now[0]][now[1]] == -1:
        answer = "HaruHaru"
        break

    for d in (0, 1), (1, 0):
        du = now[0] + d[0] * arr[now[0]][now[1]]
        dv = now[1] + d[1] * arr[now[0]][now[1]]

        if du < 0 or dv < 0 or du >= n or dv >= n:
            continue
        if arr[du][dv] != 0:
            q.append((du, dv))
print(answer)
