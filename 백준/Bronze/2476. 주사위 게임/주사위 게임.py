n = int(input())
lst = [list(map(int, input().split())) for i in range(n)]
answer = 0
for i in range(n):
    a, b, c = lst[i]
    if a == b == c:
        answer = max(answer, (10000 + a * 1000))
    elif a != b and b != c and c != a:
        answer=max(answer, (max(a, b, c) * 100))
    elif a == b or a == c:
        answer=max( answer, 1000 + a * 100)
    else:
        answer = max(answer, 1000 + b * 100)
print(answer)