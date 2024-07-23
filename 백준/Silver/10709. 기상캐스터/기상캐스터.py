import sys

input = sys.stdin.readline

h, w = map(int, input().split())

sky = [list(input()) for _ in range(h)]
result = [[-1]*w for _ in range(h)]


cloud =[]
for i in range(h):
    for j in range(w):
        if sky[i][j] == 'c':
            cloud.append([i,j])
            result[i][j] = 0

for c in cloud:
    cnt = 0
    du = c[0]
    dv = c[1]
    while 1:
        cnt += 1
        dv +=1
        if dv>=w:
            break

        if result[du][dv] == -1:
            result[du][dv] = cnt
        else:
            result[du][dv] = min(cnt, result[du][dv])

for i in range(h):
    print(*result[i])