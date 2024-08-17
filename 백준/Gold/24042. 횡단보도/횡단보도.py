import heapq
n, m = map(int, input().split()) #n 노드수 m 횡단보도 수(간선)
edges = [[] for i in range(n+1)]
for i in range(1, m+1):
    st, ed = map(int, input().split())
    edges[st].append((i, ed))
    edges[ed].append((i, st))

#시작점 pq에 넣기
#dist 시작점 0
pq = [(0, 1)] #cost / node (node는 1부터 ~ n 이므로)
inf = 700_000*2*n
dist = [inf]*(n+1)
dist[1] = 0

#pq에서 하나씩 꺼내오기
#cost값이 dist보다 크면 continue
#edge 돌기
#edge 값이 cur_cost 보다 작으면 module 더해주기( (cur_cost - next_cost)//M+1번만큼 )
#위에서 더해서 구한 값과 dist 비교후 갱신
#pq에 넣기

while pq:
    cur_cost, cur_node = heapq.heappop(pq)
    if dist[cur_node] < cur_cost:
        continue

    for e in edges[cur_node]:
        next_cost, next_node = e
        if next_cost<cur_cost:
            next_cost += ((cur_cost-next_cost)//m + 1)*m

        if dist[next_node] > next_cost:
            dist[next_node] = next_cost
            heapq.heappush(pq, (next_cost, next_node))
print(dist[n])