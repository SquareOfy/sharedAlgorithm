n = int(input())
m = int(input())
lst =[]
if m >0:
    lst = list(input().split())


now = 100
answer = abs(n-now)
if n== now:
    print(0)
else:
    for i in range(1000000):
        flag = True
        num = str(i)
        for k in lst:
            if k in num:
                flag = False
                break
        if flag:
            tmp = len(num) + abs(n-i)
            answer = min(tmp, answer)
    print(answer)