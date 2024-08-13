
n = int(input())
# 절대 answer가 될 수 없는 최댓값으로 설정
# 계속 1씩 빼서 1이 됐을 때의 값보다 크게 설정
# dp = [ n for _ in range(n + 1)]

dp = [[n] * 3 for i in range(n+1)]
for i in range(3):
    dp[n][i] = 0

for i in range(n, 1, -1):
    cnt = min(dp[i])
    if i%3 == 0:
        dp[i//3][2] = min(dp[i//3][2], cnt+1)
    if i%2 ==0:
        dp[i//2][1] = min(dp[i//2][1], cnt+1)
    dp[i-1][0] = min(dp[i-1][0], cnt+1)
print(min(dp[1]))