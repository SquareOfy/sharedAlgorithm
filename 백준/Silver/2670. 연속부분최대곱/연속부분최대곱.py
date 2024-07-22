n = int(input())

lst = [float(input()) for _ in range(n)]
answer = 0
for i in range(n):
    multiply = 1.0
    for j in range(i, n):
        multiply = multiply * lst[j]
        answer = max(multiply, answer)

print(f'{answer:.3f}')