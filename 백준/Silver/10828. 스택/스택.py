import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
stack = deque()

for _ in range(n):
    order = input().rstrip()
    
    if('push' in order):
        order, num = order.split()
        stack.append(num)
    
    elif('pop' in order):
        if(len(stack)==0): print(-1)
        else: print(stack.pop())
    elif(order == 'top'):
        if(len(stack)==0): print(-1)
        else: 
            num = stack.pop()
            stack.append(num)
            print(num)
    elif(order=='size'):
        print(len(stack))
    elif(order=='empty'):
        print(1 if len(stack)==0 else 0)