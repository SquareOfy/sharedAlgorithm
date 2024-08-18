n = int(input())
lst = list(map(int, input().split()))

answer = [lst[0]]

for i in range(1, n):
    if answer[-1] < lst[i]:
        answer.append(lst[i])
    else:
        for j in range(len(answer)):
            if answer[j] >= lst[i]:
                answer[j] = lst[i]
                break
print(len(answer))