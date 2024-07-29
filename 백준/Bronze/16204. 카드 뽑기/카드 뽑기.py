n, m, k = map(int, input().split())
answer = 0
if k > m:
    answer += m + n-k
else:
    answer += k+n-m
print(answer)