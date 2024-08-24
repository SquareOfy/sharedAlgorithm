n = int(input())
lst = list(map(int, input().split()))
answer = 0
cnt = 1
for i in range(n):
    answer += cnt*lst[i]
    if lst[i]:
        cnt+=1
    else:
        cnt = 1
print(answer)