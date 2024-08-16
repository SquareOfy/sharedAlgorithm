from collections import deque
def bfs(r,c):
    q = deque([(r,c)])
    answer[r][c] = arr[r][c]

    while q:
        i,j  = q.popleft()

        for u, v in d:
            du = i+u
            dv = j+v
            if du<0 or dv<0 or du>=n or dv>=n:
                continue
            if answer[i][j] + arr[du][dv] < answer[du][dv]:
                answer[du][dv] = answer[i][j] + arr[du][dv]
                q.append((du,dv))



t = int(input())
d = (-1, 0), (0, -1), (1, 0), (0, 1)


for tc in range(1, t+1):
    n = int(input())
    arr = [list(map(int, list(input()))) for i in range(n)]
    inf = 100*100*10

    answer = [[inf]*n for i in range(n)]
    bfs(0,0)
    print(f"#{tc} {answer[n-1][n-1]}")
