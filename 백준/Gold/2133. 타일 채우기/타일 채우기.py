n = int(input())

dp = [0]*(n+1)
dp[0] =1
if n>=2:
    dp[2] = 3
for i in range(4, n+1):
    if i%2 != 0:
        continue
    dp[i] += dp[i-2]*3
    for j in range(i-4, -1, -2):
        dp[i] += dp[j]*2

print(dp[n])