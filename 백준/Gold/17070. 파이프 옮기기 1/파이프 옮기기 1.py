n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
answer = 0

dp = [[[0]*3 for _ in range(n)] for _ in range(n)]

dp[0][1][0], dp[0][1][1], dp[0][1][2] = 1, 0, 0
for i in range(n):
    for j in range(n):
        # 옆으로 온 것
        if arr[i][j]!=1:
            if j-1 >=0:
                dp[i][j][0] += dp[i][j-1][0]+dp[i][j-1][2]
            if i-1 >=0:
                dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2]

        if i-1 >=0 and j-1>=0 and arr[i-1][j] !=1 and arr[i][j]!=1 and arr[i][j-1]!=1:
            dp[i][j][2] += sum(dp[i-1][j-1])

print(sum(dp[n-1][n-1]))