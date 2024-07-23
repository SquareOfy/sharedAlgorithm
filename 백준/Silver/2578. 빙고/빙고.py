my_arr = [list(map(int, input().split())) for _ in range(5)]
called_arr = [list(map(int, input().split())) for _ in range(5)]


def check_bingo(arr, r, c):
    answer = 0
    cnt1 = 0
    # 가로 체크
    for k in range(5):
        if arr[r][k] == 0:
            cnt1 += 1
    if cnt1 == 5:
        answer += 1
    cnt1 = 0
    for k in range(5):
        if arr[k][c] == 0:
            cnt1 += 1
    if cnt1 == 5:
        answer += 1

    # 대각선 확인
    if r == c:
        cnt1 = 0
        for i in range(5):
            if arr[i][i] == 0:
                cnt1 += 1

        if cnt1 == 5:
            answer += 1

    if 4 - r == c:
        cnt2 = 0
        for i in range(5):
            if arr[4 - i][i] == 0:
                cnt2 += 1

        if cnt2 == 5:
            answer += 1

    return answer


def call_bingo():
    global cnt

    bingo_cnt = 0
    for i in range(5):
        if bingo_cnt == 3:
            break
        for j in range(5):
            cnt += 1
            if bingo_cnt == 3:
                break
            call = called_arr[i][j]
            point = delete_number(call)

            bingo_cnt += check_bingo(my_arr, point[0], point[1])
            if bingo_cnt >= 3:
                return


def delete_number(call):
    for r in range(5):
        for c in range(5):
            if my_arr[r][c] == call:
                my_arr[r][c] = 0
                return [r, c]


cnt = 0
call_bingo()
print(cnt)
