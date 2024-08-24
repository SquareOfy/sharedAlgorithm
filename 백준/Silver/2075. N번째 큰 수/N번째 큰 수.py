import heapq
n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
answer = []
for i in range(n):
    heapq.heappush(answer, arr[n-1][i])
for i in range(n-2, -1, -1):
    for j in range(n):
        if len(answer)==n and answer[0]<arr[i][j]:
            heapq.heappop(answer)
            heapq.heappush(answer, arr[i][j])


print(answer[0])