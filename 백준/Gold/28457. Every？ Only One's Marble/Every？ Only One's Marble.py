def move(x):
    global cur, S

    cur += x
    if cur >= 4 * n - 3:  # 시작칸으로 갔다면!! 월급 받는다
        S += W*(cur//(4*n-4))

    cur %= (4 * n - 4)
    if cur == 0: cur = 4 * n - 4
    if cur in special:
        return special_move()
    else:
        return general_move()

def special_move():
    global flag, S, donation, cur, flag_cnt
    # print("특수칸 !!!!")
    if cur == n:
        flag = True
        # flag_cnt = 1
        # print("무인도야")
    elif cur == 2*n -1:
        # print("기부한 돈 얻기")
        S += donation
        donation = 0
    elif cur == 3*n-2:
        # print("우주정거장")
        S+=W
        cur = 1
    return True

def general_move():
    global gold_idx, S, donation, city_cnt
    m = board[cur][0]

    #황금열쇠일 때
    if m == 'G':
        # print("황금열쇠 줍줍")
        o, x = gold_arr[gold_idx]
        gold_idx += 1
        gold_idx %= G

        if o ==1:
            # print("돈받기")
            S += x
        elif o==2:
            # print("은행에 돈 내기")
            if S<x:
                # print("은행에 낼 돈 부족")
                return False #패했음
            S -= x
        elif o==3:
            # print("기부하기")
            if S<x:
                # print("기부할 돈 부족")
                return False
            donation+=x
            S -= x
        else:
            # print(f"============한번 더 이동 : {x} ========")
            move(x)

    #일반이면
    else:
        if not visited[cur]:
            price = int(board[cur][1])
            if S<price:
                # print("건물 살 돈 부족")
                return True
            # print("현재 위치 : ", cur)
            # print("price : ", price)
            S -= price
            # print("S : ", S)
            visited[cur] = 1
            city_cnt -= 1
    return True


n, S, W, G = map(int, input().split())
N = 4 * n - 4
board = [[] for _ in range(4 * n - 3)]
gold_arr = [list(map(int, input().split())) for _ in range(G)]
gold_idx = 0  # 뽑을 황금열쇠 index. 뽑을 때마다 index+1 mod G 해줘야 함

cur = 2  # board 입력을 위한 index
special = (1, n, 2 * n - 1, 3 * n - 2)
city_cnt = 0
for k in range(N - 4):
    lst = list(input().split())
    board[cur] = lst[:]
    if lst[0]=='L':
        city_cnt += 1
    cur += 1
    if cur in special:
        cur += 1

#### board 입력 확인 #####
# for k in range(1, N+1):
#     print(board[k])

# 무인도를 위하 변수
flag = False
flag_cnt = 0

donation = 0  # 사회복지기금
visited = [0] * (4 * n - 3)
answer = "WIN"

I = int(input())
cur = 1




for i in range(I):
    a, b = map(int, input().split())
    # print("===================", a, b , "=======================")

    if flag and flag_cnt!=3:  # 무인도 휴식중이면
        # print("무인도에 있음", flag_cnt)
        if a == b:  # 탈출 조건! 주사위 한번 더 던지러 가기 !
            # print("탈출 !! ")
            flag = False
            flag_cnt = 0
            continue
        flag_cnt += 1
        continue
    elif flag and flag_cnt ==3:
        # print("이번턴에 탈출해서 이동할거임")
        flag = False  # 무인도 이번에 탈출
        flag_cnt = 0



    result = move(a+b)
    if not result:
        answer ="LOSE"
        break

# print(visited)
# print(city_cnt)
# print(S)
if city_cnt !=0:
    answer = 'LOSE'
print(answer)