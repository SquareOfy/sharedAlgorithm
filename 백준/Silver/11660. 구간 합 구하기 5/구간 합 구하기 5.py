import sys
input = sys.stdin.readline
n, m = map(int, input().rstrip().split())

arr = [list(map(int, input().rstrip().split())) for i in range(n)]

for i in range(n):
    for j in range(1, n):
        arr[i][j] += arr[i][j-1]

for i in range(n):
    for j in range(1, n):
        arr[j][i] += arr[j-1][i]

for k in range(m):
    x1, y1, x2, y2 =  map(int, input().rstrip().split())

    large = arr[x2-1][y2-1]
    w_small = 0
    h_small = 0
    small = 0
    if x1>1:
        w_small =  arr[x1-2][y2-1]
    if y1>1:
        h_small = arr[x2-1][y1-2]
    if x1>1 and y1>1:
        small = arr[x1-2][y1-2]
    print(large-w_small-h_small+small)
