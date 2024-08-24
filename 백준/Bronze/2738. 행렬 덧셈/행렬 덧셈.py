n, m = map(int, input().split())

arr = [list(map(int, input().split())) for i in range(n)]
for i in range(n):
    lst = list(map(int, input().split()))
    for j in range(m):
        arr[i][j] += lst[j]
    print(*arr[i])