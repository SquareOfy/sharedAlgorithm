n = int(input())

lst = list(map(int, input().split()))
stack = []
answer = [0] * n
for i in range(n-1, -1, -1):
    if stack and stack[-1]>lst[i]:
        answer[i] = stack[-1]
        stack.append(lst[i])
    else:
        while stack and stack[-1] <= lst[i]:
            stack.pop()
        if stack:
            answer[i] = stack[-1]
        else:
            answer[i] = -1
    if not stack:
        answer[i] = -1
    stack.append(lst[i])

print(*answer)