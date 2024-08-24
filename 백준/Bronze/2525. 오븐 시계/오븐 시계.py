a, b = map(int, input().split())
c = int(input())

if b+c >= 60:
    h = (b+c)//60
    a = (a+h)% 24 if a+h>=24 else a+h
    b = (b+c)%60
else:
    b = b+c
print(a, b)