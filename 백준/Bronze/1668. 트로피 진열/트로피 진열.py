n = int(input())

lst = [int(input()) for _ in range(n)]

cnt1 = 1
cnt2 = 1
max1 = lst[0]
max2 = lst[n-1]
for i in range(1, n):
    if lst[i] > max1:
        max1 = lst[i]
        cnt1+=1
for i in range(n-2, -1, -1):
    if lst[i] > max2:
        max2 = lst[i]
        cnt2+=1

print(cnt1)
print(cnt2)