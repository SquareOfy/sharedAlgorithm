n, m = map(int, input().split())

arr = [list(map(int, list(input()))) for _ in range(n)]

max_len = min(n, m)
answer =0
for i in range(n):
    for j in range(m):
        #길이가 (l+1)인 정사각형이 가능할지 체크
        num = arr[i][j]
        for l in range(max_len) :
            if i+l >=n or j+l >=m:
                break
            if arr[i+l][j] != num or arr[i][j+l]!=num or arr[i+l][j+l]!=num:
                num = arr[i][j]
                continue
            answer = max((l+1)*(l+1), answer)
print(answer)