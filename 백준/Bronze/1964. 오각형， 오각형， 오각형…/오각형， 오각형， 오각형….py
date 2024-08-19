n = int(input())

dp = [0]*(n+1)
dp[1] = 5
for i in range(2,n+1):
    dp[i] = (dp[i-1]+3*i+1)%45678
print(dp[n])