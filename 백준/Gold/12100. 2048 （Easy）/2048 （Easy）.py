"""
1545 문제읽기 시작
1555 문제 이해 + 구상 완료
1631 구현 완료 후 제출 한번에 정답!!!! 오예!!!


풀이시간 : 46분

1차시도
실행시간 :620ms
메모리 : 117016kb

2차시도  : 시간 줄여보자
배열 복사를 활용해서 움직일 수 없는 상황엔 DFS를 더 돌지 않도록 해보기



========== 잘한 점 ==========
문제 꼼꼼히 읽어서 실수 없이 한번의 구현에 정답 !
dict활용해서 최대한 상하좌우 반복 if문 없이 구현하려고 노력함

======== 아쉬운 점 =============
시간 왜이렇게 오래걸렸을까
백트래킹과 동시에 최댓값을 찾거나 가지치기하는 방법 생각해보기 ^.^ ...

"""
def dfs(level, board):
    global answer
    if level == 5:
        #max 구하기
        for i in range(n):
            # print(board[i])
            answer = max(max(board[i]), answer)
        return
    move_flag = False
    for i in range(4):
        # 이 방향으로 밀어보기
        # 밀어서 결과 같으면(움직이는 칸 없으면) continue
        # 있으면 dfs에 그 배열 담아서 다음 go !
        tmp = [[0] * n for _ in range(n)]

        for k in range(n):
            tmp[k] = board[k][:]
        is_move = move(tmp, i)

        # for j in range(n):
        #     print(tmp[j])
        # print(is_move)
        # print("============================")
        if not is_move:
            continue
        dfs(level+1, tmp)

def pull(tmp,d,  st, ed, gap):
    result = False
    # 1. 해당 방향으로 빈칸 없이 내린다
    # 위아래 이동일 때(row가 작은단위)
    if d in [(-1, 0), (1, 0)]:
        for c in range(n):
            for r in range(st, ed, gap):
                if tmp[r][c] != 0:
                    continue
                # d의 반대방향으로 0이 아닐때까지 살피며 발견되는 순간 내리기
                result = True
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

    # 좌우 이동일 때(col부터 보기)
    else:
        for r in range(n):
            for c in range(st, ed, gap):
                if tmp[r][c] != 0:
                    continue
                # d의 반대방향으로 0이 아닐때까지 살피며 발견되는 순간 내리기
                result = True
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
    return result
def merge(tmp, d, st, ed, gap):
    result = False
    #상하 이동일때 (row부터)
    if d in [(-1, 0), (1, 0)]:
        for c in range(n):
            for r in range(st, ed, gap):
                #0이 아니면 윗칸과 비교 후 합치고 윗칸 0
                if tmp[r][c] ==0:
                    continue
                result = True
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
                result =True
                du = r - d[0]
                dv = c - d[1]
                if du < 0 or dv < 0 or du >= n or dv >= n:
                    continue
                if tmp[r][c] == tmp[du][dv]:
                    tmp[r][c] *= 2
                    tmp[du][dv] = 0
    return result
def move(tmp, i):
    d = dir[i] #중력의 방향
    st = d_dict[d][0]
    ed = d_dict[d][1]
    gap = d_dict[d][2]
    result1 = pull(tmp, d, st, ed, gap)
    #2. 중력 방향 기준 제일 아래쪽부터 윗칸과 비교 후 같으면 합친다.
        # 합쳤다면 윗칸 0으로 만든다
    result2 = merge(tmp, d, st, ed, gap)

    #3. 합치기 완료 후 다시 해당 방향으로 빈칸 없이 내린다.
    pull(tmp, d, st, ed, gap)
    return result1 or result2
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dir = (-1, 0), (0, -1), (1, 0), (0, 1)

d_dict = {(-1, 0): (0, n, 1), (1, 0):(n-1, -1, -1), (0, -1):(0, n, 1), (0, 1):(n-1, -1, -1)}
selected = [0]*5
answer = 0
dfs(0, arr)
print(answer)