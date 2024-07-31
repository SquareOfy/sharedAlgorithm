from collections import deque

directions = ((-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2))

t = int(input())

for tc in range(t):
    l = int(input())
    arr = [[0] * l for _ in range(l)]
    st = list(map(int, input().split()))
    ed = list(map(int, input().split()))
    q = deque([[st[0], st[1], 0]])
    arr[st[0]][st[1]] = 1
    answer = 0
    while len(q):
        now = q.popleft()
        if now[0] == ed[0] and now[1] == ed[1]:
            answer = now[2]
            break
        for d in directions:
            du = now[0] + d[0]
            dv = now[1] + d[1]
            if du < 0 or du >= l or dv < 0 or dv >= l:
                continue
            if arr[du][dv] == 0:

                q.append([du, dv, now[2] + 1])
                arr[du][dv] = 1
    print(answer)
