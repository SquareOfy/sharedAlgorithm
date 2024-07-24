n, m = map(int, input().split())

arr = [list(input()) for _ in range(n)]


#'W'로 시작하기
cnt = 0
answer = n*m
for i in range(n-7):
    for j in range(m-7):
        cnt = 0
        for w in range(8):
            for k in range(0, 7, 2):#0 2 4 6
                #W로 시작하는 줄
                if w%2 ==0:
                    if arr[i+w][j+k] != 'W':
                        cnt += 1
                    if arr[i+w][j+1+k] != 'B':
                        cnt += 1
                else:#B로 시작하는 줄
                    if arr[i+w][j+k] != 'B':
                        cnt += 1
                    if arr[i+w][j+1+k] != 'W':
                        cnt += 1
        answer = min(cnt, answer)

#'B'로 시작하기
for i in range(n - 7):
    for j in range(m - 7):
        cnt =0
        for w in range(8):
            for k in range(0, 7, 2):  # 0 2 4 6
                # W로 시작하는 줄
                if w % 2 == 0:
                    if arr[i+w][j+k] != 'B':
                        cnt += 1
                    if arr[i+w][j+1 + k] != 'W':
                        cnt += 1
                else:  # B로 시작하는 줄
                    if arr[i+w][j+k] != 'W':
                        cnt += 1
                    if arr[i+w][j+1 + k] != 'B':
                        cnt += 1
        answer =min(cnt, answer)
print(answer)