n = int(input())
lst = list(map(int, input().split()))

dp = lst[:]

for i in range(n):
    for j in range(i):
        if lst[j]<lst[i]:
            dp[i] = max(dp[j]+lst[i], dp[i])
print(max(dp))