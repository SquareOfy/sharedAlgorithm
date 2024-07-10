import sys

input = sys.stdin.readline

n = int(input())

k = 1
sum = 1
while(sum<n):
    k+=1
    sum = int((k*(k+1))/2)

start = int((k*(k-1))/2) +1
if(k%2==0):
    a = 1
    b = k
    
    while(start != n):
        a += 1
        b -= 1
        start += 1
    print(f'{a}/{b}')
else:
    a = k
    b = 1
    while(start != n):
        a -= 1
        b += 1
        start+=1
    print(f'{a}/{b}')