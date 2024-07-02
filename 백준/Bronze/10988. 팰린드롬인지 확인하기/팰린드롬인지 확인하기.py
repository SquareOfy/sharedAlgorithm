import sys

input = sys.stdin.readline

s = list(input().rstrip())

l = len(s)

result = 1
for i in range(l//2):
    if(s[i]!=s[l-i-1]):
        result = 0
        break


print(result)