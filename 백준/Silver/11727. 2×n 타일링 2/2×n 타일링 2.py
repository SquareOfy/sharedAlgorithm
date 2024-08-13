n = int(input())

dp = [0]*(n+1)
dp[1] = 1
if n >= 2:
    dp[2] = 3
mod = 10007
for i in range(3, n+1):
    dp[i] = (dp[i-2]*2+dp[i-1]) % mod
print(dp[n])