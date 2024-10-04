"""
4 x 4의 격자로 이루어진 체스판
술래 말 하나만 사용하여 도둑말을 잡으며
말의 방향이란 해당 말이 이동할 수 있는 방향을 의미하며
상하좌우, 대각선에 해당하는 8가지의 방향의 종류

말판의 위치 0번 인덱스부터 시작
각각의 도둑말에는 1이상 16이하의 번호가 서로 겹치지 않게 매겨져 있음

초기에는 (0, 0)에 있는 도둑말을 잡으며 시작

- 도둑말 이동
    도둑말은 번호가 작은 순서대로 본인이 가지고 있는 이동 방향대로 이동
    한 번의 이동에 한 칸을 이동
    도둑 말은 이동할 수 있을 때까지 45도 반시계 회전  갈 수 있는 칸을 탐색
    만약 이동할 수 있는 칸이 없다면 이동하지 않습니다.
    그 이외의 경우에는 칸을 이동
    해당 칸에 다른 도둑말이 있다면 해당 말과 위치를 바꿉니다.


- 도둑 말의 이동이 모두 끝나면 술래말이 이동
    이동 가능한 방향의 어느 칸이나 이동할 수 있습니다.
     한 번에 여러개의 칸도 이동할 수 있습니다.
    잡고자하는 도둑말로 이동할 때 지나는 칸들의 말들은 잡지 않습니다.
    술래말은 도둑말이 없는 곳으로는 이동할 수 없습니다.
    술래말은 도둑말을 잡을 때마다 잡은 도둑말의 방향을 갖게 됩니다.


만약 술래말이 이동할 수 있는 곳에 도둑말이 더이상 존재하지 않으면 게임을 끝냅니다.

"""


def oob(i, j):
    return i < 0 or i >= 4 or j < 0 or j >= 4


def move_thief(arr, dir_lst, place_lst):
    # 도둑 번호 순대로 움직이기
    for i in range(1, 17):

        cd = dir_lst[i]
        if cd == -1: continue  # 이미 잡힌 도둑은 넘기기
        cr, cc = place_lst[i]

        for k in range(8):  # 내 방향부터 8방을 돌아본다
            nd = (cd+k-1)%8+1


            di, dj = DIR[nd]
            nr = cr + di
            nc = cc + dj
            if oob(nr, nc): continue  # 범위 나가면 못가
            if arr[nr][nc] == -1: continue #술래 있어서 못가
            arr[cr][cc] = 0

            #도둑이랑 자리를 바꾸게 되면
            if arr[nr][nc] != 0:
                nxt = arr[nr][nc]
                #자리 바꾸기
                place_lst[nxt] = (cr, cc)
                arr[cr][cc] = nxt #빈칸 자리 바꾼 도둑번호로 채우기


            arr[nr][nc] = i
            place_lst[i] = (nr, nc)
            dir_lst[i] = nd
            break
    return arr, dir_lst, place_lst


def dfs(arr, score, dir_lst, place_lst, sr, sc, sd):
    # 도둑 이동
    arr, dir_lst, place_lst = move_thief(arr, dir_lst, place_lst)

    # 술래 이동 가능한 lst 찾기
    di, dj = DIR[sd]
    nr, nc = sr+di, sc+dj
    candi_lst = []
    while not oob(nr, nc):
        if arr[nr][nc] != 0:
            candi_lst.append((nr, nc))
        nr+=di
        nc+=dj
    if not candi_lst:
        global answer
        answer = max(answer, score)
        return

    tmp = [[] for _ in range(4)]
    for r, c in candi_lst:
        for t in range(4):
            tmp[t] = arr[t][:]
        tmp_dir_lst = dir_lst[:]
        tmp_place_lst = place_lst[:]

        #원래자리 빈칸 만들고
        tmp[sr][sc] = 0
        plus = tmp[r][c]
        new_d = tmp_dir_lst[plus]
        #도둑 잡기
        tmp[r][c] = -1
        tmp_dir_lst[plus] = -1
        tmp_place_lst[plus] = -1
        # print(f"============={r}, {c}로 술래 이동 후 ==========")
        # for t in range(4):
        #     print(tmp[t])
        # print('=======================================')
        dfs(tmp, score+plus, tmp_dir_lst, tmp_place_lst, r, c, new_d)



    # 종료 조건

    # 술래 이동시켜보기


direction_lst = [0] * 17
place_lst = [None] * 17
arr = [[0] * 4 for _ in range(4)]
DIR = (-1,), (-1, 0), (-1, -1), (0, -1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1)
for i in range(4):
    lst = list(map(int, input().split()))
    for j in range(0, 8, 2):
        idx = lst[j]
        d = lst[j + 1]
        direction_lst[idx] = d
        place_lst[idx] = (i, j // 2)
        arr[i][j // 2] = idx

# 위치 저장, 점수 저장 후 배열에 술래 표기
sr, sc = 0, 0
num = arr[0][0]
arr[0][0] = -1
# 방향 저장 후 잡힌 도둑 표기
sd = direction_lst[num]
direction_lst[num] = -1
place_lst[num] = -1
answer = 0
dfs(arr, num, direction_lst, place_lst, sr, sc, sd)
print(answer)