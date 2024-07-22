n = int(input())




dp = [0] * (n + 1)

dp[1] = 1
for i in range(2, n+1):
    dp[i] = dp[i-1]+i

left = 0

right = 1
answer = 0
while left < right and right <= n:
    tmp = dp[right]-dp[left]
    if tmp == n:
        answer += 1
        left += 1
    elif tmp < n:
        right += 1
    else:
        left += 1

print(answer)
