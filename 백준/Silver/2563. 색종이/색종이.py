arr = [[0]*101 for _ in range(100)]

n = int(input())
papers = [list(map(int, input().split())) for _ in range(n)]
answer =0
for a in papers:
    for i in range(a[0], a[0]+10):
        for j in range(a[1], a[1]+10):
            if arr[i][j] ==0:
                answer+= 1
                arr[i][j] = 1


print(answer)
