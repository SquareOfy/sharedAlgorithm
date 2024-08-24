def get_long_candy():
    visited_r = [[0]*n for _ in range(n)]
    visited_c = [[0]*n for _ in range(n)]

    result = 0
    for i in range(n):
        for j in range(n):
            tmp1 = arr[i][j]
            tmp2 = arr[i][j]
            if not visited_r[i][j]:
                visited_r[i][j] = 1
                cnt = 1
                while j+cnt <n and arr[i][j+cnt]==tmp1:
                    visited_r[i][j+cnt]=1
                    cnt+=1


                result = max(result, cnt)

                if result==n:
                    return n

            if not visited_c[i][j]:
                visited_c[i][j] = 1
                cnt = 1
                while i + cnt < n and arr[i+cnt][j] == tmp2:
                    visited_c[i+cnt][j] = 1
                    cnt += 1

                result = max(result, cnt)
                if result == n:
                    return n
    return result


n = int(input())
arr = [list(input()) for i in range(n)]

#0~n-1(행) ~ 0~n-1 열을 돌며 인접한 두 칸이 서로 같지 않으면 자리 바꿔보기
    #바꾸고 먹을 수 있는 최대 개수 구하는 함수 동작
answer = get_long_candy()
for i in range(n):
    for j in range(n-1):
        if arr[i][j]!=arr[i][j+1]:
            arr[i][j] , arr[i][j+1] = arr[i][j+1], arr[i][j]
            answer = max(answer, get_long_candy())

            arr[i][j] , arr[i][j+1] = arr[i][j+1], arr[i][j]
        if arr[j+1][i] != arr[j][i]:
            arr[j][i], arr[j+1][i] = arr[j+1][i], arr[j][i]
            answer = max(answer, get_long_candy())
            arr[j][i], arr[j+1][i] = arr[j+1][i], arr[j][i]
print(answer)