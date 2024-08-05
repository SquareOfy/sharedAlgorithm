import sys
sys.setrecursionlimit(10000)
t = int(input())
def dfs(i):
    if not visited[i]:
        visited[i] = 1
    else:
        return i
    if not visited[p[i]]:
        return dfs(p[i])
    else:
        return p[i]

for tc in range(t):
    n = int(input())
    edges = [[] for i in range(n+1)]
    p = [0]*(n+1)
    for i in range(n-1):
        x, y = map(int, input().split())
        edges[x].append(y)
        p[y] = x
    a, b = map(int, input().split())
    visited = [0]*(n+1)
    dfs(a)
    answer = dfs(b)
    print(answer)