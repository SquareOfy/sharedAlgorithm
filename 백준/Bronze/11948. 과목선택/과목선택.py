s = 0
first = [int(input()) for i in range(4)]
second = [int(input()) for i in range(2)]
first.sort()
second.sort()
print(sum(first[1:])+second[1])