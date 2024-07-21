n = int(input())

dp = [5000]*(n+1)

for i in range(min(6, n+1)):

    if i%3 ==0 or i%5==0:
        dp[i] = 1
    else: dp[i] = 0

for i in range(6,n+1):

    if dp[i-5]!=0 and dp[i-5] != 5000:
        dp[i] = min(dp[i], dp[i-5]+1)
    if dp[i-3]!=0 and dp[i-3] != 5000:
        dp[i] = min(dp[i], dp[i-3]+1)

answer = dp[n] if dp[n]!=5000 and dp[n]!=0 else -1
print(answer)