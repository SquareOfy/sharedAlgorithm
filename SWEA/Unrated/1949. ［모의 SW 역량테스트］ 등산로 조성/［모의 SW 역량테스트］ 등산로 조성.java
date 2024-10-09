"""
등산로 규칙
1. 등산로는 가장 높은 봉우리에서 시작
2.  반드시 높은 지형에서 낮은 지형으로 가로 또는 세로 방향으로 연결이 되어야 한다.
3. 긴 등산로를 만들기 위해 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.
"""


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= N


def dfs(level, prev, r, c, flag):
    global answer
    move_flag = False

    for di, dj in DIR:
        du, dv = r + di, c + dj
        if oob(du, dv): continue
        if visited[du][dv]: continue

        if arr[du][dv]<prev:
            visited[du][dv] = 1
            dfs(level+1, arr[du][dv], du, dv, flag)
            visited[du][dv] = 0
            move_flag = True
        elif arr[du][dv]-prev<K and not flag:
            visited[du][dv] =1
            dfs(level+1, prev-1, du, dv, 1)
            visited[du][dv] = 0
            move_flag=True
    if not move_flag:
        answer = max(answer, level)
        return


T = int(input())
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)

for t in range(1, T + 1):
    N, K = map(int, input().split())

    arr = [list(map(int, input().split())) for _ in range(N)]

    mx = 0
    for i in range(N):
        mx = max(max(arr[i]), mx)

    start_lst = []
    answer = 0
    for i in range(N):
        for j in range(N):
            if arr[i][j] == mx:
                start_lst.append((i, j))

    visited = [[0]*N for _ in range(N)]
    for r, c in start_lst:
        visited[r][c] = 1
        dfs(1, mx, r, c, 0)
        visited[r][c] = 0

    print(f"#{t} {answer}")