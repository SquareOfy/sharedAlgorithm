import heapq
n, m = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]
sushi = list(map(int, input().split()))
order = [[] for _ in range(200_001)]
answer = [0] * n

for i in range(n):
    for j in range(1, len(arr[i])):
        heapq.heappush(order[arr[i][j]], i)
for s in sushi:
    if order[s]:
        answer[heapq.heappop(order[s])]+=1
print(*answer)