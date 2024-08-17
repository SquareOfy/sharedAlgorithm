import heapq
def dijkstra(s, e, c):
    # print("다익스트라")
    # print(s, e, c)

    if s==e:
        return 0, 0

    pq = [(0, s, 0)]
    dist = [inf] * (N + 1)
    dist[s] = 0
    m_cost = 0
    while pq:
        cur_cost, cur_node, cur_max = heapq.heappop(pq)

        if dist[cur_node] < cur_cost:
            continue
        # if cur_node == e and cur_max>cost:
        #     return C+1
        for edge in edges[cur_node]:
            next_cost, next_node = edge
            if dist[next_node] > cur_cost + next_cost:
                if next_cost > c:
                    continue
                dist[next_node] = cur_cost+ next_cost
                heapq.heappush(pq, (dist[next_node], next_node, max(next_cost, cur_max)))
    # print("다익스트라 result")
    # print("최대 : ", m_cost, "비용 :",  dist[e])
    return dist[e]
    # if m_cost > cost:
    #     return dist[e], m_cost
    # else:
    #     return dist[e], m_cost
    # else:
    #     return 0, C+1

#N:노드개수 / M : 간선개수 / S: 시작지점 / E: 끝지점 / C : 보유한 돈
N, M, S, E, C = map(int, input().split())

edges = [[] for i in range(N+1)]
edge_pq = []
for i in range(M):
    st, ed, cost = map(int, input().split())
    edges[st].append((cost, ed))
    edges[ed].append((cost, st))
    edge_pq.append((cost, st, ed))
    # heapq.heappush(edge_pq, (cost, st, ed))
edge_pq.sort()
inf = 500_000*10**9
answer = inf
max_cost = 0
#edge_pq에서 cost순으로 뽑아서 걔를 포함하고서 목적지까지 비용내에 도착할 수 있는지 확인
#최대의 최소인게 정말 어렵다 ...
#edge의 어디서 끊어야 하지 ...
#앞에서 비용이 최소였던 순간에 사용한 edge는 다시 볼 필요가 없다... 이걸 어떻게 처리하지 ....
#edge_pq에서 최대부터 다 보는게 아니라 마지노선을 찾는다면?
#dist[e]가 갱신될 때 가지고 있던 최댓값을 기억하고,
#최종적으로 사용된 최댓값이 내가 뽑은 edge의 cost보다 크면,
#더 큰 cost 보러 가기
#같으면 갱신하고 더 작은 cost 보러가기 ...
#C보다 크면?
left = 0
right = M-1
while left <= right:
    mid = (left+right)//2

    cost, st, ed = edge_pq[mid]
    # print(cost, st, ed)
    # m_cost = -1
    d = dijkstra(S, E, cost)

    # 나보다 더 큰놈을 지나왔어 ! 그럼 더 큰놈을 지나칠 수밖에 없는 간선이었다는 뜻
    # C보다 더 돈이 많이 드는 길이다! 전체 비용을 줄이려면 수치심을 더 받는 것을 감수해야한다
    # 더 큰 놈 찾으러 가기
    if d>C:
        left = mid+1
        # print("왼쪽 조정")
        # print("여기")
    #내가 제일 큰 간선이었다면?
    #더 작은 수치심을 느낄 수 있는 길을 찾아봐야한다...!
    else:
        right = mid-1
        answer = min(cost, answer)
        # print("오른쪽 조정")

print(answer if answer!=inf else -1)