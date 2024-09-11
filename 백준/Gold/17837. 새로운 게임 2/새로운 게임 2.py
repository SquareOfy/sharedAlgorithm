"""

다시하기 ;;
2249
말의 방향을 mal_dir 배열로 관리하자
board배열은 말의 색깔 표시
arr 배열은 거기에 들어있는 말 리스트를 관리하자

"""
def oob(i, j):
    return i<0 or j<0 or i>=N or j>=N


def find_point(mal):
    for i in range(N):
        for j in range(N):
            if mal in arr[i][j]:
                return i, j, arr[i][j].index(mal)
    return -1, -1, -1


def move(k, r, c, d, st, flag):
    di, dj = directions[d]

    du = r + di
    dv = c + dj
    # print(f"============={k}번째 말 움직이기=============")
    # print(f"r : {r}   c : {c}    d : {d}")
    #
    if (oob(du, dv) or board[du][dv]==2) and not flag:
        # print("범위 아웃 또는 파랑 만남")
        #방향 바꾸기
        d = change_dir(d)
        dir_idx[k] = d
        di, dj = directions[d]
        du += di
        dv += dj
        return move(k, du, dv, d, st, 1)
    elif (oob(du, dv) or board[du][dv]==2) and flag:
        # print("또 범위아웃 파랑만나서 그대로 ")
        #안움직임. 그대로
        return False
    elif board[du][dv] ==0:
        #흰색이면
        arr[du][dv].extend(arr[r][c][st:])
        arr[r][c][st:] = []
    elif board[du][dv] ==1:
        tmp = arr[r][c][st:]
        tmp = tmp[::-1]
        arr[du][dv].extend(tmp)
        arr[r][c][st:] = []



    return len(arr[du][dv])>=4


def move_all():
    for k in range(1, K + 1):
        # 현재바라보는 방향
        d = dir_idx[k]
        r, c, st = find_point(k)

        if move(k, r, c, d, st, 0):
            return True

    return False


def change_dir(d):
    if d>2:
        return 7-d
    return 3-d


N , K = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]
arr = [[[] for _ in range(N)] for _ in range(N)]
dir_idx = [0]*(K+1)

#방향이동 d>2 이면 7-d
#방향이동 else 3-d
directions = (0,), (0, 1), (0, -1), (-1, 0), (1, 0)
for k in range(1,K+1):
    r, c, d = map(int, input().split())
    arr[r-1][c-1].append(k)
    dir_idx[k] = d

answer = 0

while 1:
    answer +=1
    if answer>1000:
        break
    if move_all():
        break
print(answer if answer <=1000 else -1)
