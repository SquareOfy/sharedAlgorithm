import sys

input = sys.stdin.readline

k = int(input())
numbers = []

for i in range(k):
    num = int(input())
    if num == 0:
        numbers.pop()
    else:
        numbers.append(num)

print(sum(numbers))