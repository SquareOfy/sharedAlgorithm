n, m = map(int, input().split())
edges = [[] for i in range(n + 1)]
p = [i for i in range(n + 1)]


def find_parent(x):
    if p[x] == x:
        return x
    p[x] = find_parent(p[x])
    return p[x]


def union(x, y):
    x = find_parent(x)
    y = find_parent(y)
    if x < y:
        p[y] = x
    else:
        p[x] = y


for i in range(m):
    u, v = map(int, input().split())
    edges[u].append(v)
    edges[v].append(u)

for i in range(n):
    for j in edges[i]:
        union(i, j)

visited = [0] * (n + 1)
cnt = 0
for i in range(1, n + 1):
    find_parent(i)
    if not visited[p[i]]:
        cnt += 1
        visited[p[i]] = 1
print(cnt)
