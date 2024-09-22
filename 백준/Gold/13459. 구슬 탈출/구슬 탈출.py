"""

가장 바깥행과 열 모두 막혀짐 (OOB 체크 불필요)
구멍 하나
빨강, 파랑 구슬은 한칸 가득 채우는 사이즈로 배열에 각각 하나씩 있음

빨간 구슬 빼내는게 목표
파란 구슬은 구멍에 들어가면 안 됨

중력을 이용해 구슬 굴림. 좌우 위 아래 네가지 가능
공 !!!"동시에"!!! 움직임

빨간구슬 파란구슬 함께 빠지면 실패
빨간구슬만 먼저 빠지면 성공

두 구슬 동시에 같은칸 불가능

구슬이 움직이지 않을 때까지 계속

10번 이하로 빨간구슬 꺼낼 수 있는지 여부 (1이면 가능 0이면 불가)

시간복잡도

배열 size 100
dfs 상하좌우 4를 level 10 만큼  size 100짜리 배열 탐색 :  2**20 * 100
10**8
시간 2초 ok

메모리
50byte * 100
"""

"""
구상 
1. 구슬 위치 / 구멍 위치 찾아서 기억하기 구슬 = [(br, bc), (rr, rc)] hr, hc 
2. dfs 로 level == 10일 때까지 구슬 움직여보기 
    게임에서 성공했는지 여부를 flag 로 전역에서 관리해서 dfs 내에서 가지치기하기  
    구슬 위치만 가지고 다니면 된다 ! 
    빨강/파랑 동시에 움직여보기 ? 기존에는 파랑 먼저 움직이고 빨강 만나면 빨강 보내고 파랑 보냈는데 
    코드리뷰로 동시에 움직인 사람 본 것 같은 기억,, 어떻게 해야하지? 
    일단 움직이고 같으면 d에 따라 우선순위 정해서 조정해주자. 

dfs(level, rr, rc, br, bc):
    if level == 11:
        return 
    for d in 상하좌우
        #빨간구슬 이동 
        
        #파란구슬 이동
        
        #파랑 구멍에 빠졌으면 flag 처리 후 return
        #빨강 구멍에 빠졌으면 flag 처리 후 return 
        
        #빨간 구슬위치  == 파란구슬 위치이면
            둘 중 중력 방향이랑 더 가까운 곳에 있던 애 찾기 
            아닌 애 한칸 뒤로 보내기

"""


def dfs(level, rr, rc, br, bc):
    global flag

    if flag:
        return

    # 10번 이하로 빨간구슬 꺼낼 수 있는지 여부 (1이면 가능 0이면 불가)
    if level == 10:
        return

    # 중력을 이용해 구슬 굴림. 좌우 위 아래 네가지 가능
    for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):


        # 빨간구슬 파란구슬 함께 빠지면 실패
        # 파랑 밀기 구멍 빠지면 바로 return
        nbr, nbc = roll_ball(br, bc, di, dj)
        if arr[nbr][nbc] == 'O':
            continue


        # 빨간구슬만 먼저 빠지면 성공
        # 빨강 밀기 구멍 빠졌으면 return
        nrr, nrc = roll_ball(rr, rc, di, dj)

        if arr[nrr][nrc] == 'O':
            flag = True
            return

        # 두개 위치 같으면 우선순위 확인 후 밀리는 애 한칸 뒤로 조정
        if nbr == nrr and nbc == nrc:
            # 행이 같은데 열을 옮겼거나
            # 행이든 열이든 b가 더 작은 값이었으면
            # r을 한칸 뒤로 (b가 우선)
            if di == -1 or dj == -1:
                if br < rr or bc < rc:
                    nrr -= di
                    nrc -= dj
                else:
                    nbr -= di
                    nbc -= dj
            else:
                if br < rr or bc < rc:
                    nbr -= di
                    nbc -= dj
                else:
                    nrr -= di
                    nrc -= dj
        dfs(level + 1, nrr, nrc, nbr, nbc)


def roll_ball(cr, cc, di, dj):
    while arr[cr][cc] == '.':
        cr += di
        cc += dj
        if arr[cr][cc] == 'O':  # 구멍에 빠지거라
            return cr, cc
    if arr[cr][cc] == '#':  # 한칸 뒤로 물럿거라
        cr -= di
        cc -= dj
    return cr, cc


# 배열 크기 N * M
N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]
rr, rc = -1, -1
br, bc = -1, -1
flag = False
# 빨강, 파랑 구슬은 한칸 가득 채우는 사이즈로 배열에 각각 하나씩 있음
for i in range(N):
    for j in range(M):
        if arr[i][j] == 'R':
            rr, rc = i, j
            arr[rr][rc] = '.'
        elif arr[i][j] == 'B':
            br, bc = i, j
            arr[br][bc] = '.'
dfs(0, rr, rc, br, bc)

if flag:
    print(1)
else:
    print(0)