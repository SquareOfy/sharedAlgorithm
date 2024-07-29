string = input()
n = len(string)
stk = []
answer = 0
for i in range(n):
    now = string[i]
    if now == '(':
        stk.append(now)
    else:
        stk.pop()
        if string[i-1]=='(':
            answer += len(stk)
        else:
            answer += 1
print(answer)