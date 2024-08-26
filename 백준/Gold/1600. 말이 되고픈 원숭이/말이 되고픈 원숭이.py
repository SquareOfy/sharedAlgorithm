from collections import deque
def bfs():
    q = deque([(0,0,0,0)]) #r, c, rank, k
    visited[0][0][0] = 1
    ans = w*h+1
    while q:
        r, c, rank, k = q.popleft()

        if r==h-1 and c==w-1:
            ans = min(rank, ans)
            continue
        for di, dj in monkey_d:
            du, dv = r+di, c+dj
            if du<0 or dv<0 or du>=h or dv>=w:
                continue
            if not visited[k][du][dv] and arr[du][dv] == 0:
                visited[k][du][dv] = 1
                q.append((du, dv, rank+1, k))

        if k<K:
            for di, dj in dir:
                du, dv = r+di, c+dj
                if du < 0 or dv < 0 or du >= h or dv >= w:
                    continue
                if arr[du][dv] == 0 and not visited[k + 1][du][dv]:
                    visited[k + 1][du][dv] = 1
                    q.append((du, dv, rank + 1, k + 1))
    return ans
dir = (-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2)
monkey_d = (-1, 0), (1, 0), (0, 1), (0, -1)
K = int(input())
w, h = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(h)]
visited = [[[0]*w for i in range(h)] for _ in range(K+1)]

answer = bfs()
print(answer if answer!= w*h+1 else -1)