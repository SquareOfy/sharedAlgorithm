n, m, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
l = min(n, m)//2
for k in range(r):
    for i in range(l): #바깥부터 i번째 층씩 들어감
        tmp = arr[i][i]
        #제일 바깥 기준 (0, 0)부터 시작해서 하 우 상 좌 순
        r, c = i, i
        for di, dj in (0, 1), (1, 0), (0, -1), (-1, 0):
            while 1:
                du, dv = r+di, c+dj
                if du<i or dv<i or du>=n-i or dv>=m-i or (du==i and dv==i):
                    break
                arr[r][c] = arr[du][dv]
                r = du
                c = dv
        arr[r][c] = tmp
for i in range(n):
    print(*arr[i])