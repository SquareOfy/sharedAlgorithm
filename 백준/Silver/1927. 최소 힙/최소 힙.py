import sys, heapq
input = sys.stdin.readline
heap = []
n = int(input())
for _ in range(n):
    x = int(input())
    if x:
        heapq.heappush(heap, x)
    else:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))