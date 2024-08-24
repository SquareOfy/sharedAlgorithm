import sys
input = sys.stdin.readline

m = int(input().rstrip())
s = set()
for i in range(m):
    order = list(input().split())
    o = order[0]

    if o == 'add':
        s.add(order[1])
    elif o=='check':
        print(1 if order[1] in s else 0)
    elif o=='remove':
        if order[1] in s:
            s.remove(order[1])
    elif o=='toggle':
        if order[1] in s:
            s.remove(order[1])
        else:
            s.add(order[1])
    elif o=='all':
        s.clear()
        for k in range(1, 21):
            s.add(str(k))
    elif o=='empty':
        s.clear()