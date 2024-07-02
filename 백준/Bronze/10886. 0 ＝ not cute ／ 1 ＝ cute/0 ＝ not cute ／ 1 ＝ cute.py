import sys

input = sys.stdin.readline

n = int(input())

cute = 0
for i in range(n):
    a = int(input())
    if(a==1): cute+=1

if(cute>n-cute):
    print('Junhee is cute!')
else: print('Junhee is not cute!')