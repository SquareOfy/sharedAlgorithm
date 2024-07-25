arr = [list(map(int, input().split())) for _ in range(19)]

one_win = False
two_win = False
result = [-1, -1]
d = ((1, 0), (0, 1), (1, 1), (-1, 1))
for i in range(19):
    if one_win or two_win:
        break
    for j in range(19):
        if arr[i][j] != 0:
            for dr in d:
                # 같은 방향 앞칸이 나랑 같으면 넘어가기
                if 0 <= i - dr[0] < 19 and 0 <= j - dr[1] < 19 and arr[i - dr[0]][j - dr[1]] == arr[i][j]:
                    continue
                du = i + dr[0] * 5
                dv = j + dr[1] * 5
                # 나 포함 5개 이후의 6번째 오목 확인하기
                if 0 <= du < 19 and 0 <= dv < 19 and arr[du][dv] == arr[i][j]:
                    continue
                # 오목 확인하기
                cnt = 1
                for k in range(1, 5):
                    du = i + dr[0] * k
                    dv = j + dr[1] * k
                    if du < 0 or dv < 0 or du >= 19 or dv >= 19:
                        break
                    if arr[du][dv] == arr[i][j]:
                        cnt += 1
                if cnt == 5:
                    if arr[i][j] == 1:
                        one_win = True
                    else:
                        two_win = True

                    result = [i + 1, j + 1]
                    break

if one_win:
    print(1)
    print(*result)
elif two_win:
    print(2)
    print(*result)
else:
    print(0)
