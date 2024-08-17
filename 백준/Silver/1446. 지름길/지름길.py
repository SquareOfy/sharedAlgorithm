n, d = map(int, input().split())

dist = [i for i in range(d+1)]

arr = [list(map(int, input().split())) for i in range(n)]
arr.sort()

for road in arr:
    st, ed, cost = road
    if ed > d:
        continue

    if dist[st]+cost < dist[ed]:
        dist[ed] = dist[st]+cost
        for i in range(ed+1, d+1):
            dist[i] = min(dist[i], dist[ed]+i-ed)
print(dist[d])