n = int(input())

for _ in range(n):
    string = input()
    stack = []
    flag = True
    for s in string:
        if s=='(':
            stack.append(s)
        else:
            if len(stack) == 0:
                flag = False
                break
            else:
                stack.pop()

    if not flag or len(stack) > 0:
        print("NO")
    else:
        print("YES")