n = int(input())
m = int(input())

edges = [[] for i in range(n+1)]
virus = [0]*(n+1)

for _ in range(m):
    x, y = map(int, input().split())
    edges[x].append(y)
    edges[y].append(x)




def dfs(i):
    global cnt
    virus[i] = 1

    for c in edges[i]:
        if virus[c]==0:
            dfs(c)
            cnt+=1
cnt = 0
dfs(1)

print(cnt)