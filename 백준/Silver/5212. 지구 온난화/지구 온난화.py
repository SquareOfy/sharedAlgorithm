#문제이해 ~ 구상 3시 3분
#구현완료 ~ 3시 14분

def set_min_max(r, c):
    global min_r,min_c, max_c, max_r
    min_r = min(min_r, r)
    min_c = min(min_c, c)
    max_r = max(max_r, r)
    max_c = max(max_c, c)

n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
dir = (-1, 0), (0, -1), (1, 0), (0, 1)
min_r = n
min_c = m
max_r = 0
max_c = 0
# for i in range(n):
#     for j in range(m):
for i in range(n):
    for j in range(m):
        if arr[i][j] == '.':
            continue
        tmp = 0
        for d in dir:
            du = i+d[0]
            dv = j+d[1]
            #범위 벗어나거나 . 이면 바다이므로 개수 세기
            if du<0 or dv<0 or du>=n or dv>=m:
                tmp+=1
                continue
            if arr[du][dv]=='.':
                tmp+=1
        if tmp>=3: #3면이상 바다면 1로 체크(뒤에 또세지 않기 위해)
            arr[i][j] = '1'
        else:
            set_min_max(i, j) #안잠기면 직사각형 범위 갱신

#직사각형 범위대로 출력하되, 1로 체크해둔 곳을 '.' 으로 출력
for i in range(min_r, max_r+1):
    print(''.join(arr[i][min_c:max_c+1]).replace('1', '.'), sep="")