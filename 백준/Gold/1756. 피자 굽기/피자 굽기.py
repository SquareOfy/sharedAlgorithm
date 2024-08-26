stk = []
d, n = map(int, input().split())
lst = list(map(int, input().split()))
pizza = list(map(int, input().split()))

for i in lst:
    if stk and stk[-1] < i:
        stk.append(stk[-1])
    else:
        stk.append(i)
depth = d
for p in pizza:
    while stk and stk[-1]<p:
        stk.pop()
        depth-=1
    if not stk:
        depth = -1
        break
    stk.pop()
    depth-=1

print(0 if depth==-1 else depth+1)