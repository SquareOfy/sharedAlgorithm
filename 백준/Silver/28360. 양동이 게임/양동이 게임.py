from collections import deque
def bfs():
    global answer
    q = deque([1])
    while q:
        now = q.popleft()
        if water[now] == 0:
            continue
        if k_lst[now]==0:
            continue
        w = water[now]/k_lst[now]
        water[now] = 0
        for next in edges[now]:
            water[next] += w
            q.append(next)


n, m = map(int, input().split())

edges = [[] for _ in range(n+1)]
for i in range(m):
    st, ed = map(int, input().split())
    edges[st].append(ed)

k_lst = [0] * (n+1)
for i in range(1, n+1):
    k_lst[i] = len(edges[i])

water = [0]*(n+1)
water[1] = 100
answer =0
bfs()
for i in range(1, n+1):
    if k_lst[i]==0:
        answer = max(answer ,water[i])
print(answer)