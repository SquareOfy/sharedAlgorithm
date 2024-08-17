import heapq
m, n= map(int, input().split())
arr = [list(map(int, list(input()))) for i in range(n)]

visited = [[0]*m for _ in range(n)]
visited[0][0] = 1
pq = [(0, 0, 0)] #지금까지 뚫은 벽, r, c
answer = n*m
while pq:
    punch, r, c = heapq.heappop(pq)
    if r==n-1 and c==m-1:
        answer = min(punch, answer)
        continue

    for d in (-1, 0), (0, -1), (1, 0), (0, 1):
        du = r+d[0]
        dv = c+d[1]
        if du <0 or dv<0 or du>=n or dv>=m:
            continue
        if visited[du][dv]:
            continue
        visited[du][dv] = 1
        heapq.heappush(pq, (punch+arr[du][dv], du, dv))
print(answer)