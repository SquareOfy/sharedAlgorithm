a, b, c = map(int, input().split())
d = int(input())
c = c+d

h, m = 0, 0
if c>=60:
    b += c//60
    c %= 60
    if b>=60:
        a += b//60
        b %= 60
a%=24
print(a, b, c)