n = int(input())
lst = list(map(int, input().split()))


numbers = set(lst)
numbers = sorted(numbers)
dict_num = dict({numbers[i] : i for i in range(len(numbers))})
answer = []
for i in lst:
    answer.append(dict_num[i])

print(*answer)

