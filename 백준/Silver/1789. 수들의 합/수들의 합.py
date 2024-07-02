import sys

input = sys.stdin.readline

n = int(input())
i = 1
cnt = 0
while(n>0):
    if(n<i):
        break
    n-=i
    cnt+=1
    i+=1

print(cnt)