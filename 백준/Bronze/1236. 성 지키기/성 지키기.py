n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
answer = 0

for i in range(n):
    #이 행에는 높을 필요 없음
    if 'X' in arr[i]:
        continue
    #없으면 이 행에 하나 놔야하는데 어느 열에 놓을지 찾기
    #이 열에 놓을까?
    flag = False
    for j in range(m):
        #이 세로줄에 X가 있는지 보자
        for k in range(n):
            if arr[k][j]=='X':
                break
        else:
            arr[i][j] = 'X'
            flag = True
            break
    if not flag:
        arr[i][0] = 'X'
    answer+=1


# for i in range(n):
#     print(*arr[i])
arr = [list(i) for i in zip(*arr)]
for i in range(m):
    #이 행에는 높을 필요 없음
    if 'X' in arr[i]:
        continue
    #없으면 이 행에 하나 놔야하는데 어느 열에 놓을지 찾기
    #이 열에 놓을까?
    flag = False
    for j in range(n):
        #이 세로줄에 X가 있는지 보자
        for k in range(n):
            if arr[k][j]=='X':
                break
        else:
            arr[i][j] = 'X'
            flag = True
            break
    if not flag:
        arr[i][0] = 'X'
    answer+=1
print(answer)