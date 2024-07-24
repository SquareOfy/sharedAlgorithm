while 1:
    string = input()
    if string == '.':
        break
    stack = []
    flag = True
    for s in string:
        if s=='(' or s=='[':
            stack.append(s)
        elif s==')':
            if len(stack) == 0 or (len(stack) !=0 and stack[-1]!='('):
                flag = False
                break
            elif stack[-1] == '(':
                stack.pop()
        elif s==']':
            if len(stack) == 0 or (len(stack) !=0 and stack[-1]!='['):
                flag = False
                break
            else:
                stack.pop()

    if not flag or len(stack):
        print("no")
    else:
        print("yes")
