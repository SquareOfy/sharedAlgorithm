


N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

directions = (0, 0), (-1, 0), (1, 0), (0, -1), (0, 1) #상어 우선순위 보고 여기서 뽑아오기
shark_order = []
smell_arr = [[[0]*2 for _ in range(N)] for _ in range(N)] #상어 번호, k
shark_direction = [0]+list(map(int, input().split()))

shark_order.append([])
for i in range(1, M+1):
    tmp = [[]]
    for j in range(4):
        tmp.append(list(map(int, input().split())))
    shark_order.append(tmp)

answer = 0
cnt = M

while 1:

    for i in range(N):
        for j in range(N):
            if arr[i][j] != 0:
                smell_arr[i][j] = [arr[i][j], K]
    if cnt ==1 or answer >1000:
        break
    answer += 1
    # if answer >= 10 :
    #     break
    #움직임 동시에
    move = [[0]*N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            # print(arr[i][j])
            if arr[i][j]==0:
                continue
            num = arr[i][j]
            dk = shark_direction[num]
            dir_lst = shark_order[num][dk]
            non_flag = False

            #냄새 없는 것 우선 찾기
            for d in dir_lst:
                di, dj = directions[d]
                du = i+di
                dv = j+dj
                if du<0 or du>=N or dv<0 or dv>=N:
                    continue
                if smell_arr[du][dv][0] !=0:
                    continue

                #여기로 이동
                if move[du][dv]!=0:
                    if move[du][dv]>num:
                        #내가이겨먹음
                        move[du][dv] = num
                    cnt -= 1
                else:
                    move[du][dv] = num
                shark_direction[num] = d
                break
            else:

                #냄새 없는 곳 없으면 나랑 같은 거라도 찾아
                for d in dir_lst:
                    di, dj = directions[d]
                    du = i + di
                    dv = j + dj
                    if du < 0 or du >= N or dv < 0 or dv >= N:
                        continue
                    if smell_arr[du][dv][0] != num:
                        continue

                    # 여기로 이동
                    if move[du][dv] != 0:
                        if move[du][dv] > num:
                            move[du][dv] = num
                        cnt -= 1
                    else:
                        move[du][dv] = num
                    shark_direction[num] = d
                    break
                else:
                    #그것도 못찾음?
                    #이동불가
                    move[i][j] = num #원래 위치로!
    #################

    ##################3333
    #이동을 마쳤으니 move를 smell과 arr에 반영하자
    for i in range(N):
        arr[i] = move[i][:]
        for j in range(N):
            if arr[i][j] ==0 :
                continue
            smell_arr[i][j] = [arr[i][j], K]
    # print("==================move 이동 ================")
    # for i in range(N):
    #     print(arr[i])

    #이동을 마쳤으니 smell을 깎자
    for i in range(N):
        for j in range(N):
            if smell_arr[i][j][0] == 0:
                continue
            if arr[i][j] !=0:
                continue
            smell_arr[i][j][1] -= 1
            if smell_arr[i][j][1]==0:
                smell_arr[i][j][0] = 0
    # print("======================그때의 smell =============")
    # for i in range(N):
    #     for j in range(N):
    #         print(smell_arr[i][j])
    #     print()
print(answer if answer <1001 else -1)
