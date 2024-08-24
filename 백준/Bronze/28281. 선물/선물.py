n, x = map(int, input().split())
lst = list(map(int, input().split()))
answer = 1000*1_000_000*2
for i in range(n-1):
    tmp = (lst[i]+lst[i+1])*x
    answer = min(answer, tmp)
print(answer)