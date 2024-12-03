from collections import deque
 
 
def oob(i, j):
    return i < 0 or j < 0 or i >= M or j >= N
 
 
def bfs(pr, pc):
    q = deque([(pr, pc, 1, -1)])
    visited = [[0] * N for _ in range(M)]
    visited[pr][pc] = 1
    while q:
        cr, cc, rank, d = q.popleft()
        if cr == gr and cc == gc:
            return d
        for i in range(4):
            di, dj = DIR[i]
            nr, nc = cr + di, cc + dj
            if oob(nr, nc): continue
            if arr[nr][nc] == 1: continue
            if wall_arr[nr][nc][0]!=0: continue
            if visited[nr][nc]<= rank+1 and visited[nr][nc]!=0: continue
            if d==-1:
                q.append((nr, nc, rank+1, i))
            else:
                q.append((nr, nc, rank+1, d))
            visited[nr][nc] = rank+1
    return -1
 
 
def move(player_num):
    global first_catch
    pr, pc = place_lst[player_num]
    d = bfs(pr, pc)
    if d!=-1:
        di, dj = DIR[d]
        pnr = pr+di
        pnc = pc+dj
        place_lst[player_num] = [pnr, pnc]
        player_arr[pr][pc] -= 1
        if pnr==gr and pnc == gc:
            out_lst[player_num] =1
            catch_lst[player_num] = 1
            if first_catch==-1:
                first_catch = player_num
        else:
            player_arr[pnr][pnc]+=1
        return True
    return False
 
 
def find_treasure():
    for i in range(M):
        for j in range(N):
            if arr[i][j] == 2:
                return i, j
 
 
 
def find_shoot(player_num):
    pr, pc = place_lst[player_num]
    min_dist = float("inf")
    sr, sc = -1, -1
    # 상하좌우 B칸을 보기 벽 있으면 break
    for di, dj in DIR:
        for b in range(1, B + 1):
            nr, nc = pr+di*b, pc+dj*b
            if oob(nr, nc) or arr[nr][nc]==1:
                break
            if player_arr[nr][nc] ==0:
                continue
 
            # 맨해튼 거리 최소 / 행 큰 칸 / 열 큰 칸 없으면 안던지기
            dist = get_dist(nr, nc, gr, gc)
            if min_dist > dist:
                min_dist = dist
                sr, sc = nr, nc
            elif min_dist==dist and (sr, sc )<(nr, nc):
                sr, sc = nr, nc
    return sr, sc
 
def rotate_place(r, c):
    tr, tc = r-rotate_r, c-rotate_c
    return tc+rotate_r, R-1-tr+rotate_c
 
 
def get_dist(i, j, x, y):
    return abs(i-x)+abs(j-y)
 
 
T = int(input())
DIR = (-1, 0), (1, 0), (0, -1), (0, 1)
for t in range(1, T + 1):
    M, N = map(int, input().split())
    K, B, D, R = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(M)]
    player_arr = [[0]*N for _ in range(M)]
    bomb_lst = [0] * (K + 1)
    out_lst = [0] * (K + 1)
    catch_lst = [0] * (K + 1)
    first_catch = -1
    place_lst = [[0] * 2 for _ in range(K + 1)]
    wall_arr = [[[0, 0] for _ in range(N)] for _ in range(M)]
    gr, gc = find_treasure()
    rotate_r, rotate_c = gr - R//2, gc-R//2
 
    for i in range(1, K + 1):
        r, c, bomb_cnt = map(int, input().split())
        r -= 1
        c -= 1
        place_lst[i] = [r, c]
        player_arr[r][c] += 1
        bomb_lst[i] = bomb_cnt
    turn = 0
    while 1:
        if sum(out_lst) == K:
            break
 
        turn+=1
        if turn > 1000:
            break
 
        move_cnt = 0
 
        for i in range(1, K + 1):
            if out_lst[i]: continue
            # 슥
            # bfs . 상하좌우 우선순위.
            isMove = move(i)
            if isMove: move_cnt+=1
            if out_lst[i]: continue
 
            # print("===================슥 이동 후 : ", i, " ===========================")
            # print(place_lst)
            #
            # for z in range(M):
            #     print(*player_arr[z])
            # print()
            # print("임시 벽 ")
            # for z in range(M):
            #     print(*wall_arr[z])
            # print("======================================================")
 
 
            # 쏴
            # 슥에서 이동 + 남아있는 폭탄 있을 때
            if isMove and bomb_lst[i]>0:
                sr, sc = find_shoot(i)
 
                if sr!=-1 and sc!=-1:
                    # 폭탄 던지기
                    # print(sr, sc, "에 던짐")
                    for j in range(1, K+1):
                        tr, tc = place_lst[j]
                        if tr==sr and tc==sc:
                            out_lst[j] = 1
 
                    player_arr[sr][sc] = 0
                    wall_arr[sr][sc]=[i,D]
                    bomb_lst[i] -= 1
 
 
            # print("================== 쏴 후 ===========================")
            # print(place_lst)
            #
            # for z in range(M):
            #     print(*player_arr[z])
            # print()
            # print("임시 벽 ")
            # for z in range(M):
            #     print(*wall_arr[z])
            # print("======================================================")
 
 
            # 쾅
            for r in range(M):
                for c in range(N):
                    if wall_arr[r][c][0] != 0 and wall_arr[r][c][0]!= i:
                        wall_arr[r][c][1]-=1
                        if wall_arr[r][c][1]==0:
                            wall_arr[r][c][0] = 0
 
            # print("================== 쾅 후 ===========================")
            # print(place_lst)
            #
            # for z in range(M):
            #     print(*player_arr[z])
            # print()
            # print("임시 벽 ")
            # for z in range(M):
            #     print(*wall_arr[z])
            # print("======================================================")
 
        #회전
        tmp = [[0] * R for _ in range(R)]
        wall_tmp = [[0] * R for _ in range(R)]
        player_tmp = [[0] * R for _ in range(R)]
 
        for rr in range(rotate_r, rotate_r + R):
            tmp[rr - rotate_r] = arr[rr][rotate_c:rotate_c + R]
            wall_tmp[rr - rotate_r] = wall_arr[rr][rotate_c:rotate_c + R]
            player_tmp[rr - rotate_r] = player_arr[rr][rotate_c:rotate_c + R]
 
        tmp = list(map(list, zip(*tmp[::-1])))
        wall_tmp = list(map(list, zip(*wall_tmp[::-1])))
        player_tmp = list(map(list, zip(*player_tmp[::-1])))
 
        for rr in range(rotate_r, rotate_r + R):
            arr[rr][rotate_c:rotate_c + R] = tmp[rr - rotate_r][:]
            wall_arr[rr][rotate_c:rotate_c + R] = wall_tmp[rr - rotate_r][:]
            player_arr[rr][rotate_c:rotate_c + R] = player_tmp[rr - rotate_r][:]
 
        # player자리도 회전
        for j in range(1, K + 1):
            pr, pc = place_lst[j]
            if rotate_r <= pr < rotate_r + R and rotate_c <= pc < rotate_c + R:
                nr, nc = rotate_place(pr, pc)
                place_lst[j] = [nr, nc]
 
 
        # print("================== 회전 후 ===========================")
        # print(place_lst)
        #
        # for z in range(M):
        #     print(*player_arr[z])
        # print()
        # print("임시 벽 ")
        # for z in range(M):
        #     print(*wall_arr[z])
        # print("======================================================")
 
 
 
 
 
 
        if move_cnt == 0:
            break
 
    print(f"#{t} ", end="")
    if turn >1000 or first_catch == -1:
        print(-1)
    else:
        print(first_catch, sum(catch_lst), turn)