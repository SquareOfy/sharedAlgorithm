
left = list(input())
right = []

n = int(input())

for i in range(n):
    order = list(input().split())
    o = order[0]
    if o == 'L':
        if left:
            right.append(left.pop())
    elif o =='D':
        if right:
            left.append(right.pop())
    elif o == 'B':
        if left:
            left.pop()
    elif o=='P':
        left.append(order[1])

print(''.join(left), end="")
print(''.join(right[-1::-1]))
