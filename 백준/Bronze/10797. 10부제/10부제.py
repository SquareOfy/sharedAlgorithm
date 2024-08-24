d = int(input())
lst = list(map(int, input().split()))
cnt = 0
for i in lst:
    if d==i:
       cnt+=1
print(cnt)