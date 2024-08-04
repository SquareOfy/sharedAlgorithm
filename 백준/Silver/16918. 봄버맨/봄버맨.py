r, c, n = map(int, input().split())

arr = [list(input()) for i in range(r)]

for i in range(r):
    for j in range(c):
        if arr[i][j] == 'O':
            arr[i][j] = 1
        else:
            arr[i][j] = -1

if n>=8:
    n%=4
    n+=4


time = 1

while 1:
    if time >= n:
        break
    #폭탄 모두 설치 1초
    for i in range(r):
        for j in range(c):
            if arr[i][j] == 2:
                for d in (-1, 0), (0, -1), (1, 0), (0, 1):
                    du = i + d[0]
                    dv = j + d[1]
                    if du <0 or dv<0 or du>=r or dv>=c:
                        continue
                    arr[du][dv] = -1
    for i in range(r):
        for j in range(c):
            if arr[i][j] == -1:
                arr[i][j] = 0
            else:
                arr[i][j] += 1
    time += 1


    if time==n:
        break
    #폭탄 터지기
    bomb = []
    for i in range(r):
        for j in range(c):
            if arr[i][j] == 2:
                bomb.append([i,j])
                arr[i][j] = -1

            elif arr[i][j] != -1:
                arr[i][j] += 1
    for b in bomb:
        i = b[0]
        j = b[1]
        arr[i][j] = -1
        for d in (-1, 0), (0, -1), (1, 0), (0, 1):
            du = i + d[0]
            dv = j + d[1]
            if du < 0 or dv < 0 or du >= r or dv >= c:
                continue
            arr[du][dv] = -1


    time+= 1

    if time ==n:
        break
# for i in range(r):
#     print(*arr[i], sep="   ")

for i in range(r):
    for j in range(c):
        if arr[i][j] == -1:
            arr[i][j] = '.'
        else:
            arr[i][j] = 'O'


for i in range(r):
    print(*arr[i], sep="")