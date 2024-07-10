import sys

input = sys.stdin.readline

k = int(input())
numbers = []
for _ in range(k):
    num = int(input())
    if(num==0):
        numbers.pop()
    else:
        numbers.append(num)
result =0
for i in numbers:
    result+= i

print(result)