answer = -1
idx = [-1, -1]
for i in range(9):
    lst = list(map(int, input().split()))
    for j in range(9):
        if lst[j]>answer:
            answer = lst[j]
            idx = [i+1, j+1]

print(answer)
print(*idx)