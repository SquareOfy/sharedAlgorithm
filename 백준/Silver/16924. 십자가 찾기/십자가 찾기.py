from collections import deque
def bfs(r, c):
    q = deque([[(r,c),0]])


    while q:
        d, rank = q.popleft()
        if d == (r,c):
            for k in (-1, 0), (0, -1), (1, 0), (0, 1):
                du = r+k[0]
                dv = c+k[1]
                if du<0 or du>=n or dv<0 or dv>=m:
                    return rank
                if arr[du][dv]=='.':
                    return rank
                q.append([k, rank+1])
        else:
            du = r+d[0]*rank
            dv = c+d[1]*rank
            if du < 0 or du >= n or dv < 0 or dv >= m:
                return rank
            if arr[du][dv] == '.':
                return rank
            q.append([d, rank+1])

def fill_visited(r, c, rank):
    if rank ==0:
        return
    visited[r][c] =1
    for i in range(1, rank):
        visited[r+i][c] = 1
        visited[r-i][c] = 1
        visited[r][c+i] = 1
        visited[r][c-i] = 1

def check():
    for i in range(n):
        for j in range(m):
            if arr[i][j] == '*' and not visited[i][j]:
                return False
    return True
n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
answer = []
visited = [[0] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if arr[i][j]=='*':
            size = bfs(i, j)

            if size>0:
                fill_visited(i, j, size)
                for s in range(1, size):
                    answer.append([i+1,j+1,s])
if check():
    print(len(answer))

    for a in answer:
        print(*a)
else:
    print(-1)