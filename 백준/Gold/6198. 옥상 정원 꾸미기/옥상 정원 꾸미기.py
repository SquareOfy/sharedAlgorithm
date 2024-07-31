n = int(input())

stk = []
lst = [int(input()) for _ in range(n)]
answer = 0
for i in range(n-1, -1, -1):
    cnt = 0

    while stk and stk[-1][0] < lst[i]:
        stk.pop()
    if stk:
        answer += stk[-1][1] - i -1
    else:
        answer += n - i -1
    stk.append([lst[i], i])

print(answer)