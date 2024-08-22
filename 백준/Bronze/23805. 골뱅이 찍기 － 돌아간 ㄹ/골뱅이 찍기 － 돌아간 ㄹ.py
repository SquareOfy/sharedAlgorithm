n = int(input())

arr = [['@']*(n*5) for _ in range(n*5)]


for i in range(0, 4*(n)):
    for j in range(3*n, 4*n):
        arr[i][j] = ' '
        arr[5*n-1-i][5*n-1-j]=' '
for lst in arr:
    print(*lst, sep="")
