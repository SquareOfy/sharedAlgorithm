n = int(input())
answer = 1001
for i in range(n):
    a, b = map(int, input().split())
    if a<=b:
        answer = min(answer, b)
print(answer if answer!=1001 else -1)