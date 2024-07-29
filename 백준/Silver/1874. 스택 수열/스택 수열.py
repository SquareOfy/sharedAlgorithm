n = int(input())

lst = list(int(input()) for _ in range(n))
stack = []
result = []
idx = 0
i = 1
while idx < n and i<=n:
    while stack and stack[-1] == lst[idx]:
        stack.pop()
        result.append('-')
        idx += 1
        if idx >= n:
            break
    if idx >= n:
        break
    if i == lst[idx]:
        result.append('+')
        result.append('-')
        idx+=1
    else:
        result.append('+')
        stack.append(i)
    i+= 1


while stack and stack[-1] == lst[idx]:
    stack.pop()
    result.append('-')
    idx += 1
    if idx >= n:
        break

if stack:
    print("NO")
else:
    for i in result:
        print(i)




