n = int(input())
numbers = list(map(int, input().split()))

lst = []

for i in range(n):
    num = numbers[i]
    lst.insert( len(lst)-num, i+1)

print(*lst)