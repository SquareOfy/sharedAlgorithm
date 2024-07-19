picture = [[0]*101 for _ in range(101)]

n, m = map(int, input().split())
for i in range(n):
    lx, ly, rx, ry = map(int, input().split())

    for r in range(lx, rx+1):
        for c in range(ly, ry+1):
            picture[r][c] += 1

answer =0
for i in range(101):
    for j in range(101):
        if(picture[i][j]>m): answer+=1

print(answer)