n = int(input())
lst = [0]+[int(input()) for _ in range(n)]

dp = [[0]*2 for _ in range(n+1)]
dp[1][0] = lst[1]
dp[1][1] = lst[1]

for i in range(2, n+1):
    dp[i][0] = max(dp[i-2])+lst[i] #2칸 점프 했을 때
    dp[i][1] = dp[i-1][0] + lst[i]

print(max(dp[n]))
