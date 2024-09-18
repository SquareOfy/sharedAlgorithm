"""

10*10

green arr[4:][:4]
blue arr[:4][4:]

1.
한 줄이 다 차면 그 줄 사라지고 위에서 사라진 개수만큼 당겨옴 (점수 + 줄 수만큼)
초록 : 같은 행의 모든 열[:4]
파랑 : 같은 열의 모든 행[:4]

2. 한줄 다 찬 행/열 모두 점수 획득한 후에 처리
블록 다 내리고 연한 부분에 블록이 있는지 확인하기
있으면 있는 만큼 아래 행 / 열 삭제 => 아래 / 오른쪽으로 이동




"""
#한칸짜리일 때 쌓일 idx 찾는 함수
def find_idx(is_row, r, c):
    #r,c 빨간색에 놓인 위치
    #is_row True이면 초록
    if is_row:
        for i in range(6, 10):
            if arr[i][c]==0:
                continue
            return i-1
        return 9
    # False이면 파랑
    else:
        for i in range(6, 10):
            if arr[r][i]==0:
                continue
            return i-1
        return 9
def check_line(is_row, k):
    if is_row:
        for i in range(4):
           if arr[k][i] == 0:
               return False
    else:
        for i in range(4):
            if arr[i][k] == 0:
                return False
    return True

def push(is_row, idx):
    if is_row:
        arr[idx][:4] = [0]*4
        for i in range(idx, 4, -1):
            arr[i][:4] = arr[i-1][:4]
        arr[4][:4] = [0]*4
    else:
        for i in range(4):
            arr[i][idx] = 0
        for j in range(idx, 4, -1):
            for i in range(4):
                arr[i][j] = arr[i][j-1]
        for i in range(4):
            arr[i][4] = 0
#input
N = int(input())
score = 0
arr = [[0]*10 for _ in range(10)]
for i in range(N):
    # 블록 내리기 구현..
    # 파랑은 제일 오른쪽 열부터 해당 행의 값을 보며 빈칸이 나올 때까지 index찾기
    # 세로 두개짜리는 두 행을 모두 보고 그 중 min을 골라 그 열에 표시
    # 가로 두개짜리는 그냥 찾고 그 index랑 index-1에 체크
    # 초록은 제일 아래 행부터 해당 열의 값을 보며 빈칸이 처음으로 나오는 index찾기
    # 가로 두개 짜리는 두 열을 보고 그 중 min을 골라 그 행에
    # 세로 두개 짜리는 그냥 찾고 그거랑 그거보다 한칸 위(idx-1)에 체크

    t, x, y = map(int, input().split())
    r_idx = find_idx(1, x, y)
    c_idx = find_idx(0, x, y)

    #한칸
    if t == 1:
        arr[r_idx][y] = 1 #초록색에 내리기
        arr[x][c_idx] = 1 #파란색에 내리기
    # 1*2
    elif t==2:
        # r_idx1 = find_idx(0, x, y)
        r_idx2 = find_idx(1, x, y+1)
        r_idx = min(r_idx, r_idx2)
        #초록색에 내리기 (가로로 2개)
        arr[r_idx][y] = 1
        arr[r_idx][y+1] = 1

        #파란색에 내리기
        arr[x][c_idx] = 1
        arr[x][c_idx-1] = 1
        if check_line(0,c_idx-1):
            #
            push(0, c_idx-1)
            score+=1


    #2*1
    else:
        c_idx2 = find_idx(0, x+1, y)
        # print("x : ", x)
        # print("2*1일 때 c_idx : ", c_idx)
        # print("2*1일 때 c_idx2 : ", c_idx2)

        c_idx = min(c_idx2, c_idx)

        arr[r_idx][y] = 1
        arr[r_idx-1][y] = 1
        arr[x][c_idx] = 1
        arr[x+1][c_idx] = 1

        if check_line(1, r_idx-1):
            #해당 줄 아래로 밀기
            push(1, r_idx-1)
            score+=1
    #위 세개 공통 로직
    # 내리고 나서 내린 곳의 초록(행) 파랑(열) 4개 다 찼나 체크
    if check_line(1, r_idx):
        # 내리기
        push(1, r_idx)

        # 점수더하기
        score+=1
    if check_line(0, c_idx):
        # 오른쪽으로 밀기
        push(0, c_idx)
        # for j in range(c_idx, 0, -1):
        #     for i in range(4):
        #         arr[i][j] = arr[i][j-1]
        # 점수더하기
        score+=1

    # print("=========================")
    # for i in range(10):
    #     print(arr[i])
    #
    # print("========================")
    #다 내리고 점수 얻고 나서 연한칸 확인
    #초록색
    cnt_r = 0
    for i in range(4, 6):
        if 1 in arr[i][0:4]:
            cnt_r+= 1

    for k in range(cnt_r):
        push(1, 9)

    cnt_c = 0
    for i in range(4, 6):
        for j in range(4):
            if arr[j][i] == 1:
                cnt_c += 1
                break
    # print("cnt_c : " ,cnt_c)
    for k in range(cnt_c):
        push(0, 9)


# for i in range(10):
#     print(arr[i])
#
# print()
answer = 0
for i in range(4, 10):
    for j in range(4):
        if arr[i][j] == 1:
            answer += 1
        if arr[j][i] == 1:
            answer +=1

print(score)
print(answer)