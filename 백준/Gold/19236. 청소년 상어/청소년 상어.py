"""

=============구상 ==================
**초기세팅
 상어 (0, 0) 에 넣어두고 그 자리에 있는 물고기 방향 가지기.


1. 물고기 이동
    1~16 순서대로 이동
    이동방법
     - 자기가 가진 방향으로 갈 수 있으면(상어x / oob x) 이동
        -물고기 있으면 자리바꾸기
        -없으면 이동(빈칸이랑 바꾸기 해야함)
    - 없으면 45도 반시계 회전
        - 갈 수 있는데 찾아서 가고
        - 한바퀴 다 돌아도 이동 불가하면 이동 x

2. 상어 이동
    - 자신의 방향대로 가능한 칸 수 중 하나로 이동
        그 방향에서 가능한 칸 수 찾기
        그 칸대로 for문 돌며 dfs 호출
        - 배열 복사
        - 물고기 먹기

dfs ( 배열, 상어위치, 상어 방향, 먹은 물고기 번호의 합)

    #물고기 이동시키는 함수 호출

    #상어 이동 가능한 칸 카운트
    # 0이면 return / 정답 갱신

    #
    # for 이동 가능한 칸
    #     배열 복사
    #     복사한 배열에서 이동 + 물고기 먹기
    #     dfs 호출

"""

def dfs(arr, shark, sd, sm, fish_dir):

    # print("+++++++++++++++++++++++Dfs 호출 ++++++++++++++++")
    # print(dead_lst)
    # print(sm)
    # print("fish 정보 : ")
    # print(fish_dir)
    # print()

    global answer
    #물고기 이동 함수 호출
    # print(dead_lst)
    move_fish(arr, shark, fish_dir)

    # print("================move 후 =================")
    # print(dead_lst)
    # for k in range(4):
    #     print(arr[k])
    #
    # print(fish_dir)
    # print("=======================================")
    #
    #
    # print("shark 정보 !! : " , sd, eight_dir[sd])

    # 상어 이동 가능한 칸 카운트
    cnt = cal_shark_move(arr, shark, sd)
    # print("cnt : ", cnt)
    r, c = shark
    # 0이면 return / 정답 갱신
    di, dj = eight_dir[sd]

    flag = False
    # for 이동 가능한 칸
    for k in range(1, cnt+1):
        # print("k : ", k)
        du = shark[0]+di*k
        dv = shark[1]+dj*k
        if arr[du][dv]==0:
            continue

        #     배열 복사
        tmp_fish_dir = fish_dir[:]
        tmp = [[] for _ in range(4)]
        for y in range(4):
            tmp[y] = arr[y][:]

        #     복사한 배열에서 이동 + 물고기 먹기
        tmp[r][c] = 0
        catch = tmp[du][dv]
        n_sd = tmp_fish_dir[catch]
        tmp_fish_dir[catch] = -1
        tmp[du][dv] = -1
        flag = True

        # print(f"===============물고기 잡아먹음  {catch}후 =================")
        # print(dead_lst)
        # for k in range(4):
        #     print(tmp[k])
        #
        # print(fish_dir)
        # print("=======================================")

        # print("catch : " , catch , "죽임!!!!!!!!!!!!!!!!")
        # print(tmp_fish_dir)


        #     dfs 호출
        dfs(tmp, (du, dv), n_sd, sm + catch, tmp_fish_dir)
    if cnt == 0 or not flag:
        answer = max(answer, sm)
        return

def find_fish(arr, i):
    # print(f"=======================find fish {i} ===================")
    for y in range(4):
        for x in range(4):
            if arr[y][x] == i:
                return y, x

def move_fish(arr, shark, tmp_fish_dir):
    # print(tmp_fish_dir)
    for i in range(1, 17):
        # print(i)
        # print(tmp_fish_dir[i])
        if tmp_fish_dir[i]==-1:
            continue
        #물고기 찾기
        y, x = find_fish(arr, i)
        d = tmp_fish_dir[arr[y][x]]
        #자기 자리부터 회전
        for k in range(8):
            di, dj = eight_dir[(d+k)%8]
            du, dv = y+di, x+dj
            if oob(du, dv) or (du, dv) == shark:
                continue
            tmp_fish_dir[arr[y][x]] = (d+k)%8
            arr[y][x], arr[du][dv] = arr[du][dv], arr[y][x]
            break

def cal_shark_move(arr, shark, sd):
    du, dv = shark
    di, dj = eight_dir[sd]
    cnt = 0
    # print("sd" , sd)
    while 1:
        du += di
        dv += dj
        # print("du, dv ", du, dv)
        if oob(du, dv):
            break
        cnt+=1
    return cnt

def oob(i, j):
    return i<0 or j<0 or i>=4 or j>=4

arr = [[0]*4 for _ in range(4)]
eight_dir = (-1, 0), (-1, -1), (0, -1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1)
fish_dir = [0]*17

#4개의 줄에 물고기 번호 / 방향 순으로 8개 숫자 들어옴
for i in range(4):
    lst = list(map(int, input().split()))
    for j in range(0,8,2):
        a, b = lst[j], lst[j+1]
        arr[i][j//2] = a
        fish_dir[a] = b-1


answer = 0
# for i in range(4):
#     print(arr[i])
r, c = 0, 0
num = arr[0][0]
sd = fish_dir[num]
# print(fish_dir)
arr[0][0] = -1
fish_dir[num] = -1

dfs(arr, (r, c), sd ,num, fish_dir )
print(answer)