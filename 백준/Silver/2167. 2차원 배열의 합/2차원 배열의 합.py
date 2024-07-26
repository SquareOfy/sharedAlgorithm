n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

k = int(input())
for i in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    sm = 0
    for r in range(x1-1, x2):
        for c in range(y1-1, y2):
            sm += arr[r][c]
    print(sm)