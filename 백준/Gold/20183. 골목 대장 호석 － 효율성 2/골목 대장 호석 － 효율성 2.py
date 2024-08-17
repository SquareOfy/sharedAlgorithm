import heapq
#N:노드개수 / M : 간선개수 / S: 시작지점 / E: 끝지점 / C : 보유한 돈
N, M, S, E, C = map(int, input().split())

edges = [[] for i in range(N+1)]

for i in range(M):
    st, ed, cost = map(int, input().split())
    edges[st].append((cost, ed))
    edges[ed].append((cost, st))

inf = 500_000*10**9

pq = [(0, 0, 1)] #max / dist / node
dist = [inf] * (N+1) # max를 넣어야하나 dist를 넣어야하나 ... 최단경로가 아닌걸 ..!
max_money = [inf]*(N+1)
max_money[0] = 0

while pq:
    cur_max, cur_cost, cur_node = heapq.heappop(pq)
    if max_money[cur_node] < cur_max:
        continue
    if dist[cur_node] < cur_cost:
        continue

    for e in edges[cur_node]:
        #지금 연결할 선이 지금까지의 max보다 크면 max 갱신
        next_cost, next_node = e
        if next_node!=E and next_cost>cur_max and next_cost+cur_cost <=C:
            max_money[next_node] = next_cost
            dist[next_node] = min(dist[next_node], next_cost+cur_cost)
            heapq.heappush(pq, (next_cost, next_cost+cur_cost, next_node))
        if next_node==E and next_cost+cur_cost <= C:
            max_money[next_node] = min(max_money[next_node], max(next_cost, cur_max))

print(max_money[E] if max_money[E] != inf else -1)