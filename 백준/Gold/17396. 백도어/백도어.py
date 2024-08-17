import heapq
n, m = map(int, input().split())
lst = list(map(int, input().split()))
edges =[[] for i in range(n)]
for i in range(m):
    a, b, t = map(int, input().split())
    edges[a].append((t, b))
    edges[b].append((t, a))

pq = [(0, 0)]
inf = 300_000*100_000
dist = [inf]*n
dist[0] = 0
#다익스트라
while pq:
    #pq에서 heappop으로 꺼내 그 지점과 연결된 간선 확인
    #단, lst[i]가 1이면 방문 불가
    #꺼내온 노드의 지금까지의 가중치 > dist[cur] 이면 넘어가기
    #지금까지 온 경로+연결된 간선 가중치 < dist[next] 이면 갱신

    cur_cost, cur_node = heapq.heappop(pq)
    if dist[cur_node] < cur_cost:
        continue

    for e in edges[cur_node]:
        next_cost, next_node = e[0], e[1]
        #n-1분기점이 아니면서 상대의 시야에 보이면 방문불가.
        if next_node!= n-1 and lst[next_node]:
            continue
        if next_cost+cur_cost < dist[next_node]:
            dist[next_node] = next_cost+cur_cost
            heapq.heappush(pq, (dist[next_node], next_node))

print(dist[n-1] if dist[n-1]!=inf else -1)