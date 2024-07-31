from collections import deque
m, n = map(int, input().split())
directions = ((-1, 0), (0, -1), (1, 0), (0, 1))

arr = [list(map(int, input().split())) for _ in range(n)]
q = deque([])
answer = -1
cnt = 0
for r in range(n):
    for c in range(m):
        if arr[r][c] == 1:
            q.append([r, c, 0])

        elif arr[r][c] == 0:
            cnt += 1
while q:
    now = q.popleft()
    r = now[0]
    c = now[1]
    day = now[2]
    answer = max(day, answer)
    if day > 0:
        cnt -= 1
    if cnt == 0:
        break

    for d in directions:
        du = r+d[0]
        dv = c+d[1]
        if du<0 or du >= n or dv<0 or dv>=m:
            continue
        if arr[du][dv] == 0:
            q.append([du, dv, day+1])
            arr[du][dv] = 1


if cnt == 0:
    print(answer)
else:
    print(-1)