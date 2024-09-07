import sys
sys.setrecursionlimit(100000)
def dfs(level, node):
    global answer
    if level==k:
        return
    for next in edges[node]:
        answer+= lst[next]
        dfs(level+1, next)
n, k = map(int, input().split())
edges = [[] for _ in range(n)]
for i in range(n-1):
    a, b = map(int, input().split())
    edges[a].append(b)
lst = list(map(int, input().split()))
answer = lst[0]
dfs(0, 0)
print(answer)