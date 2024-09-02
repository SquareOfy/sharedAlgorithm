"""
1545 문제읽기 시작
1555 문제 이해 + 구상 완료



"""
def dfs(level):
    global answer
    if level == 5:
        # print("selected")
        # print(selected)
        #max 구하기
        move()
        m = 0
        for i in range(n):
            m = max(m, max(tmp[i]))

        #정답 갱신하기
        answer = max(m, answer)
        return

    for i in range(4):
        selected[level] = i
        dfs(level+1)

def pull(tmp,d,  st, ed, gap):
    # 1. 해당 방향으로 빈칸 없이 내린다
    # 위아래 이동일 때(row가 작은단위)
    if d in [(-1, 0), (1, 0)]:

        # print(d)
        for c in range(n):
            for r in range(st, ed, gap):
                # print(r)
                if tmp[r][c] != 0:
                    continue
                # d의 반대방향으로 0이 아닐때까지 살피며 발견되는 순간 내리기
                du, dv = r, c
                while 1:
                    du -= d[0]
                    dv -= d[1]
                    # print(du, dv)
                    if du < 0 or dv < 0 or du >= n or dv >= n:
                        break
                    if tmp[du][dv] != 0:
                        # print("땡김")
                        tmp[r][c] = tmp[du][dv]
                        tmp[du][dv] = 0

                        break

    # 좌우 이동일 때(col부터 보기)
    else:
        for r in range(n):
            for c in range(st, ed, gap):
                # print(r)
                if tmp[r][c] != 0:
                    continue
                # d의 반대방향으로 0이 아닐때까지 살피며 발견되는 순간 내리기
                du, dv = r, c
                while 1:
                    du -= d[0]
                    dv -= d[1]
                    if du < 0 or dv < 0 or du >= n or dv >= n:
                        break
                    if tmp[du][dv] != 0:
                        tmp[r][c] = tmp[du][dv]
                        tmp[du][dv] = 0
                        break

def merge(tmp, d, st, ed, gap):
    #상하 이동일때 (row부터)
    if d in [(-1, 0), (1, 0)]:
        for c in range(n):
            for r in range(st, ed, gap):
                #0이 아니면 윗칸과 비교 후 합치고 윗칸 0
                if tmp[r][c] ==0:
                    continue
                du = r-d[0]
                dv = c-d[1]
                if du<0 or dv<0 or du>=n or dv>=n:
                    continue
                if tmp[r][c]==tmp[du][dv]:
                    tmp[r][c] *=2
                    tmp[du][dv]=0

    # 좌우 이동일 때(col부터 보기)
    else:
        for r in range(n):
            for c in range(st, ed, gap):
                # 0이 아니면 윗칸과 비교 후 합치고 윗칸 0
                if tmp[r][c] == 0:
                    continue
                du = r - d[0]
                dv = c - d[1]
                if du < 0 or dv < 0 or du >= n or dv >= n:
                    continue
                if tmp[r][c] == tmp[du][dv]:
                    tmp[r][c] *= 2
                    tmp[du][dv] = 0

def move():
    for i in range(n):
        for j in range(n):
            tmp[i][j] = arr[i][j]

    for i in selected:
        d = dir[i] #중력의 방향
        st = d_dict[d][0]
        ed = d_dict[d][1]
        gap = d_dict[d][2]
        pull(tmp, d, st, ed, gap)
        #2. 중력 방향 기준 제일 아래쪽부터 윗칸과 비교 후 같으면 합친다.
            # 합쳤다면 윗칸 0으로 만든다
        merge(tmp, d, st, ed, gap)

        #3. 합치기 완료 후 다시 해당 방향으로 빈칸 없이 내린다.
        pull(tmp, d, st, ed, gap)

        # print(f"move에서 {i}번째 move 후  tmp 결과 확인 ")
        # print(selected)
        # for j in range(n):
        #     print(tmp[j])
        # print()
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dir = (-1, 0), (0, -1), (1, 0), (0, 1)
tmp = [[0] * n for _ in range(n)]

d_dict = {(-1, 0): (0, n, 1), (1, 0):(n-1, -1, -1), (0, -1):(0, n, 1), (0, 1):(n-1, -1, -1)}
selected = [0]*5
answer = 0
dfs(0)
print(answer)