n = int(input())
lst = [-1]+list(map(int, input().split()))
m = int(input())
for _ in range(m):
    gender, num = map(int, input().split())

    if gender == 1: #남
        for i in range(num, n+1, num):
            lst[i] += 1
            lst[i] %= 2
    if gender == 2:
        lst[num] = (lst[num]+1)%2
        left = num-1
        right = num+1
        while left>=1 and right<=n and lst[left]==lst[right]:
            lst[left] = (lst[left]+1)%2
            lst[right] = (lst[right]+1)%2
            left -= 1
            right += 1
if n<=20:
    print(*lst[1:])
else:
    idx = 1
    for i in range(n//20):
        print(*lst[idx:idx+20])
        idx +=20
    if n%20!=0:
        print(*lst[idx:])