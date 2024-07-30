v = int(input())
e = int(input())
connected = [[] for i in range(v+1)]

def dfs(i):
    global cnt
    visited[i] = 1
    cnt += 1

    for k in connected[i]:
        if not visited[k]:
            dfs(k)


for i in range(e):
    st, ed = map(int, input().split())
    connected[st].append(ed)
    connected[ed].append(st)

visited = [0]*(v+1)
cnt = -1
dfs(1)
print(cnt)

