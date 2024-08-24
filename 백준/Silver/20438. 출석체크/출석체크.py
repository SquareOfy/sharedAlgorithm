def attend(i):
    if i in sleep:
        return
    visited[i] = 0
    for j in range(i*2, n+3, i):
        if j in sleep or visited[j]==0:
            continue
        attend(j)

n, k, q, m= map(int, input().split())
sleep = set(map(int, input().split()))
students = list(map(int, input().split()))
visited = [1]*(n+3)

for i in students:
    if i in sleep:
        continue
    attend(i)
for j in range(m):
    s, e= map(int, input().split())
    print(sum(visited[s:e+1]))