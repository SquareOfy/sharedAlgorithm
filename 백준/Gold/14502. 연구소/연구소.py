from collections import deque
def dfs(level, idx):
    global answer
    if level==3:
        # 벽 3개 다 세웠으면 바이러스 퍼뜨리기
        cnt = bfs() #퍼진 개수
        answer = max(answer, safe-3-cnt)
        return
    for i in range(idx, b):
        r, c = blanks[i]
        arr[r][c] = 1
        dfs(level+1, i+1)
        arr[r][c] = 0

def bfs():
    q = deque(virus)
    visited = [[0]*m for _ in range(n)]
    for i, j in virus:
        visited[i][j] = 2
    cnt = 0

    while q:
        r, c = q.popleft()

        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = r+di
            dv = c+dj
            if du<0 or dv<0 or du>=n or dv>=m:
                continue
            if visited[du][dv]:
                continue
            if arr[du][dv]!=0:
                continue
            visited[du][dv] = 2
            q.append((du, dv))
            cnt+=1
    # print()
    # for i in range(n):
    #     print(arr[i])
    # print()
    # print()
    # for i in range(n):
    #     print(visited[i])
    # print()

    return cnt

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
blanks = []
virus = []
safe = 0
answer = 0
for i in range(n):
    for j in range(m):
        if arr[i][j]==0:
            safe+=1
            blanks.append((i,j))
        elif arr[i][j]==2:
            virus.append((i, j))

b = len(blanks)
#빈칸 중에 3곳 고르기
dfs(0, 0)
print(answer)