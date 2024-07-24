n = int(input())

dp = [[1000000]*(3) for i in range(n+1)]

if n >= 2:
    dp[2][1] = 1
    dp[2][1] = 1
if n >= 3:
    dp[3][0] = 1

if n>4:
    for i in range(4, n+1):
        if i%3 == 0:
            dp[i][0] = min(dp[i//3])+1
        if i%2 == 0:
            dp[i][1] = min(dp[i//2])+1
        dp[i][2] = min(dp[i-1]) +1
if n>1:
    print(min(dp[n]))
else:
    print(0)