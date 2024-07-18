import sys

input = sys.stdin.readline

t = int(input())

stack = []
for i in range(t):
    order = list(input().split())

    if(order[0]=='push'):
        stack.append(order[1])
    elif(order[0]=='pop'):
        if(len(stack)>0):
            print(stack.pop())
        else: print(-1)
    elif(order[0]=='top'):
        if (len(stack) > 0):
            print(stack[len(stack)-1])
        else:
            print(-1)
    elif(order[0]=='size'):
        print(len(stack))
    else:
        if(len(stack)==0): print(1)
        else: print(0)