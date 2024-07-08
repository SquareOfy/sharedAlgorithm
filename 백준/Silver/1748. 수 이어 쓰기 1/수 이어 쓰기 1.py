import sys

input = sys.stdin.readline

n = int(input())

a = 9
i = 1

answer =0
while(a <= n):
    answer += i*a
    n-= a
    a*= 10
    i += 1

answer += i*n

print(answer)