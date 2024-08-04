import sys
input = sys.stdin.readline
n, m = map(int, input().split())

d = dict()
pockets = [0]*(n+1)
for i in range(1, n+1):
    pockets[i] = input().rstrip()
    d[pockets[i]] = i

for i in range(m):
    q = input().rstrip()
    if d.get(q) is not None:
        print(d[q])
    else:
        print(pockets[int(q)])
