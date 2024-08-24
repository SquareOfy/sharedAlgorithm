n = int(input())
c, s = 100, 100
for i in range(n):
    a, b = map(int, input().split())
    if a < b:
        c-= b
    elif a>b:
        s -= a
print(c)
print(s)