import heapq, sys
input = sys.stdin.readline
n = int(input())
hq = []

for i in range(n):
    x = int(input())
    if x == 0:
        if len(hq) == 0 :
            print(0)
        else:
            print(heapq.heappop(hq))
    else:
        heapq.heappush(hq, x)
