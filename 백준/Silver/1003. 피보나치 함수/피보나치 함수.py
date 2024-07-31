import sys
input = sys.stdin.readline
t = int(input().rstrip())
dp = [0, 1]

def fibo(k):
    if len(dp) > k:
        return dp[k]
    dp.append(fibo(k-1)+fibo(k-2))
    return fibo(k-1)+fibo(k-2)

fibo(40)
for tc in range(t):
    n = int(input())
    if n == 0:
        print(1, 0)
    elif n==1:
        print(0, 1)
    else:
        print(dp[n-1], dp[n])