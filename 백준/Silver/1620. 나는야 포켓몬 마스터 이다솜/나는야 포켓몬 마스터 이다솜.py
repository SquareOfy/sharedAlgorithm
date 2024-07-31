n, m = map(int, input().split())

d = dict()
pockets = [0]*(n+1)
for i in range(1, n+1):
    pockets[i] = input()
    d[pockets[i]] = i

for i in range(m):
    q = input()
    if d.get(q) is not None:
        print(d.get(q))
    else:
        print(pockets[int(q)])
