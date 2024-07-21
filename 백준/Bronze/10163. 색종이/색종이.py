import sys

input = sys.stdin.readline


n = int(input())
plane = [[0]*1001 for _ in range(1001)]
surface = [0]*(n+1)
for i in range(1,n+1):
    x1, y1, w, h = map(int, input().split())
    for x in range(x1, x1+w):
        for y in range(y1,y1+h):
            if plane[x][y] != 0:
                surface[plane[x][y]] -= 1
            plane[x][y] = i
            surface[i] += 1

print(*surface[1:], sep="\n")