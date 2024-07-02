import sys

input = sys.stdin.readline

t = int(input())
arr = []

for i in range(t):
    result=0
    a,b,c=map(int, input().split())
    if(a==b and b==c and c==a):
        result = 10000+a*1000
    elif(a!=b and b!=c and a!=c):
        result = max(a,b,c)*100
    elif(a==b or a==c):
        result = 1000+a*100
    elif(b==c):
        result = 1000+b*100
    
    arr.append(result)

print(max(arr))