from collections import deque
#입력
r, c, m = map(int, input().split())
shark = {}
arr = [[0] * (c+2) for _ in range(r+1)]
q = deque([])
directions = (-1, 0), (0, 1), (1, 0), (0, -1)
d_change = [0, 0, 2, 1, 3] #위 아래 우 좌를 상 우 하 좌로 change
# 1 위 / 2 아래 / 3 오른쪽 4 왼쪽
answer =0
for i in range(1, m+1):
    sr, sc, s, d, z = map(int, input().split())
    arr[sr][sc] = i
    shark[i] = (s, d_change[d], z)
    q.append((sr, sc))

for x in range(1, c+1): #오른쪽 한칸 이동 구현
    #이 열에서 가장 가까운 상어 잡기
    for y in range(1, r+1):
        if arr[y][x] == 0:
            continue
        answer += shark[arr[y][x]][2]
        # print(x)
        # print(f"잡았당 : {arr[y][x]} {shark[arr[y][x]][2]}")
        arr[y][x] = 0
        break
    #상어 이동
    move = [[0] * (c + 2) for _ in range(r + 1)]
    new_shark = set()
    for k in range(len(q)):
        #꺼낸 상어
        cr, cc = q.popleft()
        #상어 정보

        num = arr[cr][cc]
        #이미 잡힌 상어

        if num == 0:
            continue
        s, d, z = shark[num]

        #바꾼 방향으로 가다가 자리 벽 만나면 방향 반대로 남은 칸 가는 거임
        nr = cr
        nc = cc
        di, dj = directions[d]
        for p in range(s):
            nr+=di
            nc+=dj
            # 상어가 범위 벗어나면 방향 반대로 바꿈
            if nr < 1 or nr > r or nc < 1 or nc > c:
                di*=-1 #방향바꾸기
                dj*=-1 #방향바꾸기
                d= (d+2)%4 #바꿀 방향 저장해야해서 d 관리
                nr += di*2 #되돌아오기 + 반대로 방향바꿔 한칸
                nc += dj*2
        #이동 마쳤으면 새로운 방향정보 업데이트
        shark[num] = (s, d, z)

        #바꾼 방향으로 이동하는데 이미 상어가 있다면? 큰놈이 잡아먹기
        #아니면 이동
        if move[nr][nc] !=0:
            #이미 상어가 있고 그 상어가 나보다 크면
            b_size = shark[move[nr][nc]][2]
            if b_size>z:
                #나는 죽음
                continue

        #상어 있어도 내가 더 크거나, 상어 없으면
        #내가 들어가기
        move[nr][nc] = num
        #다음 상어 위치
        new_shark.add((nr, nc))
    # print(list(new_shark))
    q.extend(list(new_shark))
    # print(f"=============={x}초 후 상어 상태================")
    # for i in range(1, r+1):
    #     print(move[i])
    #상어 이동정보 업데이트
    for i in range(r+1):
        arr[i] = move[i][:]
print(answer)




