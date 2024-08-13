n = int(input())
seq = list(map(int, input().split()))

dp = [1]*n

#dp를 채울 index
for i in range(1, n):
    for j in range(i): #내 앞에 있는 수열들 탐색
        if seq[j] < seq[i]: #나보다 내 앞에 작은 값이 있으면
            #그 값까지 가장 긴 증가하는 부분수열 길이에 +1한 값과
            #현재의 dp값 중 큰 값으로 갱신
            dp[i] = max(dp[i], dp[j]+1) #
print(max(dp))

