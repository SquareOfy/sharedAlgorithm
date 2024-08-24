answer = -1
idx = -1
for i in range(9):
    n = int(input())
    if n>answer:
        idx = i+1
        answer = n
print(answer)
print(idx)