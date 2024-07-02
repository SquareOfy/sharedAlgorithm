import sys

input = sys.stdin.readline

v = int(input())
arr = list(input().rstrip())

a =0
b =0
for i in arr:
    if(i=='A'): a+=1
    else: b+=1

if(a==b): print('Tie')
elif(a>b): print('A')
else: print('B')