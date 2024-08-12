import heapq
n, m = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]

sushi = list(map(int, input().split()))
hq = []
answer = [0]*n
sushi.sort()
for i in range(n):
    for j in range(1, len(arr[i])):
        heapq.heappush(hq, (arr[i][j], i))

for i in range(m):
    while 1:
        if not hq:
            break

        p = heapq.heappop(hq)
        if p[0] > sushi[i]:
            heapq.heappush(hq, p)
            break
        if p[0] == sushi[i]:
            answer[p[1]] += 1
            break
print(*answer)