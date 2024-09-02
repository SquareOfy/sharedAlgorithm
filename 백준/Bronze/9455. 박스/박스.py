t = int(input())

for tc in range(t):
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]

    answer = 0
    for j in range(m):
        for i in range(n-1, 0, -1):
            if arr[i][j] == 1:
                continue
            nr = i-1
            while 0<=nr<n and arr[nr][j] == 0:
                nr -=1

            if nr <0:
                continue
            arr[i][j] = 1
            arr[nr][j] = 0
            # print(i, nr)
            answer += i-nr

    print(answer)