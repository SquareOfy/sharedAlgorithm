import heapq
n = int(input())
m = int(input())
edges = [[] for i in range(n+1)]
for i in range(m):
    st, ed, cost = map(int, input().split())
    edges[st].append((cost, ed))
start, end = map(int, input().split())
INF = 100_000*100_1000 #최댓값으로 정하기 : 간선의 개수 * 가중치 최댓값
pq = [(0,start)] #초기 cost : 0 초기 위치 1
dist = [INF]*(n+1) #idx까지 오는 데에 드는 최소비용을 기록할 거리 배열
dist[start] = 0 #초기 위치인 1의 거리 0으로 세팅

while pq:
    cur_cost, cur_node = heapq.heappop(pq) #현재까지 최소비용이 드는 경우 뽑아서
    if dist[cur_node] < cur_cost:
        continue
    for next_cost, next_node in edges[cur_node]: #그 노드에서 연결할 수 있는 노드들 중
        if cur_cost+next_cost<dist[next_node]: #현재까지 기록된 다음 노드까지의 최단거리보다 cur_node를 거쳐오는 게 비용이 적으면
            dist[next_node] = cur_cost+next_cost #갱신하고
            heapq.heappush(pq, (dist[next_node], next_node)) #pq에 넣어 그 노드에서 또 다른 노드로 갈 수 있는 곳 알아보기
print(dist[end])