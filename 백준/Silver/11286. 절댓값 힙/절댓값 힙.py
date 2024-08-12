import sys, heapq
input = sys.stdin.readline
n = int(input())
lst = [int(input()) for _ in range(n)]
hq = []
for x in lst:
    if x!=0:
        heapq.heappush(hq, (abs(x), x))
    else:
        if len(hq):
            print(heapq.heappop(hq)[1])
        else:
            print(0)