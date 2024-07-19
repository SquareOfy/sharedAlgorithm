n = int(input())
answer = 0
for i in range(1, n + 1):
    h = n // i
    answer += h
    if i * i <= n:
        answer += 1
print(answer // 2)