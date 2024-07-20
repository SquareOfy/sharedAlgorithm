import sys

input = sys.stdin.readline
sys.setrecursionlimit(2503)

d = ((-1, 0), (0, -1), (1, 0), (0, 1), (-1,-1), (-1, 1), (1, -1), (1, 1))

def dfs(r, c):
    for i in d:

        du = r + i[0]
        dv = c + i[1]


        if du < 0 or du >= h or dv < 0 or dv >= w or place[du][dv] == 0 or visited[du][dv] == 1:
            continue
        visited[du][dv] = 1
        dfs(du, dv)



while 1:
    w, h = map(int, input().split())

    if w == 0 and h == 0:
        break

    answer = 0
    place = [ list(map(int, input().split())) for _ in range(h)]
    visited = [[0] * w for _ in range(h)]
    for r in range(h):
        for c in range(w):
            if place[r][c] == 1 and visited[r][c] == 0:
                visited[r][c] = 1
                dfs(r, c)
                answer += 1

    print(answer)