from collections import deque

n = int(input())

arr = [list(map(int, list(input()))) for i in range(n)]
result = []
dir = ((-1, 0), (0, -1), (1, 0), (0, 1))


def bfs(r, c):
    q = deque([[r, c]])
    cnt = 0
    while len(q) != 0:
        now = q.popleft()
        cnt += 1
        for d in dir:

            du = now[0] + d[0]
            dv = now[1] + d[1]
            if du < 0 or dv < 0 or du >= n or dv >= n:
                continue
            if arr[du][dv] == 1:
                arr[du][dv] = -1
                q.append([du, dv])

    return cnt


for r in range(n):
    for c in range(n):
        cnt =0
        if arr[r][c] == 1:
            arr[r][c] = -1
            cnt = bfs(r, c)

        if cnt != 0:
            result.append(cnt)

result.sort()
print(len(result))
print(*result, sep="\n")
