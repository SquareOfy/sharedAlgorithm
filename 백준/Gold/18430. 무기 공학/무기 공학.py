def oob(i, j):
    return i<0 or j<0 or i>=N or j>=M

def dfs(i, j, power, lst):

    global answer
    answer = max(answer, power)
    if i==N:
        return

    for r in range(i, N):
        for c in range(M):
            if visited[r][c]: continue
            # 4가지 모양 체크
            #ㄱ  / ㄱ q반대
            if not oob(r+1, c) and not visited[r+1][c]:
                if not oob(r, c-1) and not visited[r][c-1]: #ㄱ
                    visited[r][c-1] = 1
                    visited[r][c] = 1
                    visited[r + 1][c] = 1

                    plus = arr[r][c]*2 + arr[r+1][c]+arr[r][c-1]
                    nc = c + 1 if c + 1 < M else 0
                    nr = r if nc != 0 else r + 1
                    dfs(nr, nc, power+plus, lst+[(r, c, 'ㄱ')])
                    visited[r][c-1] = 0
                    visited[r+1][c] = 0
                    visited[r][c] = 0


                if not oob(r, c+1) and not visited[r][c+1]: #ㄱ 반대
                    visited[r][c+1]=1
                    visited[r + 1][c] = 1
                    visited[r][c] = 1
                    plus = arr[r][c]*2 + arr[r+1][c]+arr[r][c+1]
                    nc = c + 1 if c + 1 < M else 0
                    nr = r if nc != 0 else r + 1
                    dfs(nr, nc, power+plus,lst+[(r, c, 'ㄱ반대')])
                    visited[r][c+1]=0
                    visited[r+1][c] = 0
                    visited[r][c] = 0


            if not oob(r-1, c) and not visited[r-1][c]:
                if not oob(r, c-1) and not visited[r][c-1]: #ㄴ반대
                    visited[r][c-1] = 1
                    visited[r][c] = 1
                    visited[r - 1][c] = 1

                    plus = arr[r][c]*2 + arr[r-1][c]+arr[r][c-1]
                    nc = c + 1 if c + 1 < M else 0
                    nr = r if nc != 0 else r + 1
                    dfs(nr, nc, power+plus, lst+[(r, c, 'ㄴ반대')])
                    visited[r - 1][c] = 0
                    visited[r][c-1] = 0
                    visited[r][c] = 0

                if not oob(r, c+1) and not visited[r][c+1]: #ㄴ
                    visited[r][c+1]=1
                    visited[r][c] = 1
                    visited[r - 1][c] = 1

                    plus = arr[r][c]*2 + arr[r-1][c]+arr[r][c+1]
                    nc = c + 1 if c + 1 < M else 0
                    nr = r if nc != 0 else r + 1
                    dfs(nr, nc, power+plus, lst+[(r, c, 'ㄴ')])
                    visited[r][c+1]=0
                    visited[r][c] = 0
                    visited[r-1][c] = 0




N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
if N==1 or M==1:
    print(0)

else:
    visited = [[0]*M for _ in range(N)]
    answer = 0
    dfs(0, 0, 0, [])
    print(answer)