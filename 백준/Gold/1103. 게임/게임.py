import sys
sys.setrecursionlimit(100000)

def dfs(level, i, j):

    global answer, flag

    #무한 루프인 적 있었다면 바로 종료
    if flag:
        return -1

    #방문처리
    visited[i][j]= 1
    dp[i][j] = level

    for di, dj in dir:
        k = arr[i][j]
        du, dv = i+di*k, j+dj*k

        #점프하는 방향으로
        if du < 0 or dv < 0 or du >= n or dv >= m or arr[du][dv]==0:
            continue

        #방문한 적이 있으면서 싸이클이 발생할 조건은 1?
        if visited[du][dv]:
            flag = True
            return -1
        if dp[du][dv] > level:
            continue
        #dp를 dfs로 끝까지 돌려서 얻은 return 값과 max 비교해서 갱신
        answer = max(level+1, answer)
        dp[du][dv] = max(dp[du][dv], level+1)
        dfs(level+1, du, dv)

    #방문 해제
    visited[i][j] = 0




def change(i):
    if i=='H':
        return 0
    return int(i)


n, m = map(int, input().split())
arr = [list(map(change, list(input()))) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
dp = [[0] * m for _ in range(n)]
answer = 1
dir = (-1, 0), (0, 1), (1, 0), (0, -1)
flag = False

#0,0부터 출발 !
dfs(1, 0, 0)
# for i in range(n):
#     print(dp[i])
print(answer if not flag else -1)