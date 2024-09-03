n, m = map(int, input().split())

arr = [list(input()) for _ in range(n)]
answer =0
for i in range(n):
    r_flag = False
    for j in range(m):
        if arr[i][j] == '-':
            if r_flag:
                continue
            answer+=1
            r_flag = True
        elif arr[i][j] != '-' and r_flag:
            r_flag = False
for i in range(m):
    c_flag = False
    for j in range(n):
        if arr[j][i] == '|':
            if c_flag:
                continue
            answer+=1
            c_flag = True
        elif arr[j][i] != '|' and c_flag:
            c_flag = False


print(answer)