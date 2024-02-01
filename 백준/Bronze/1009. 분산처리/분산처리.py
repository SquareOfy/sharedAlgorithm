import sys
n = int(sys.stdin.readline())

list = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    b = b%4
    if b%4 ==0:
        b=4
    s = (a**b)%10
    if s==0:
        s=10
    list.append(s)

for i in list:
    print(i)