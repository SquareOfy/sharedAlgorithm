n = int(input())
arr = [[0]*100 for _ in range(100)]

papers = [list(map(int, input().split())) for _ in range(n)]
dr = (-1, 0, 1, 0)
dc = (0, -1, 0, 1)
for a in papers:
    for i in range(a[0], a[0]+10):
        for j in range(a[1], a[1]+10):
            arr[i][j] = 1

answer = 0

for i in range(100):
    for j in range(100):
        if arr[i][j] == 0:
            continue
        for k in range(4):
            du = i + dr[k]
            dv = j + dc[k]
            if du<0 or dv<0 or du>=100 or dv >=100:
                answer+= 1
                continue
            if arr[du][dv] == 0:
                answer+=1


print(answer)