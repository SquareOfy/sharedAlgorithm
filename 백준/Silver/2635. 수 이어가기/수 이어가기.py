n = int(input())
numbers = []

answer = 0
answer_list = []
for i in range (n, 0, -1):
    numbers.append(n)
    numbers.append(i)

    while 1:
        gap = numbers[-2] - numbers[-1]
        if gap < 0: break
        numbers.append(gap)

    if answer < len(numbers):
        answer = max(answer, len(numbers))
        answer_list = numbers.copy()

    numbers.clear()

print(answer)
print(*answer_list)