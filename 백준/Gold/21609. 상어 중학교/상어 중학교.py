from collections import deque
def set_block():
    #같은 블록인 기준
    #     - 상하좌우 연결
    #     - 일반블록&무지개블록으로만
    #     - 무조건 일반블록 하나 이상 포함
    #     - 같은 색의 일반블록
    # 블록 그룹의 기준 블록은 무지개 블록이 아닌 블록 중에서 행의 번호가 가장 작은 블록, 그러한 블록이 여러개면 열의 번호가 가장 작은 블록이다.
    # 기준블록은 정렬해서 찾기
    visited = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            if arr[i][j]>=1:
                lst = bfs(i, j, arr[i][j], visited)
                if len(lst)<2:
                    continue
                clean_rainbow(visited)
                a, b = find_leader_block(lst)
                blocks.append(((a,b), lst)) # 0 : 기준 블록 좌표, 1:블록목록

def clean_rainbow(visited):
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 0:
                visited[i][j] = 0
def find_leader_block(lst):

    lst.sort()
    i = 0
    while arr[lst[i][0]][lst[i][1]] ==0:
        i+=1

    return lst[i]


def oob(i, j):
    return i>=n or i<0 or j>=n or j<0


def bfs(r, c, color, visited):
    visited[r][c] = 1
    q = deque([(r, c)])
    lst = []

    while q:
        cr, cc = q.popleft()
        lst.append((cr, cc))
        for di, dj in dir:
            du = cr+di
            dv = cc+dj
            if oob(du, dv) or visited[du][dv]:
                continue
            if arr[du][dv] == -1:
                continue
            if arr[du][dv] != 0 and arr[du][dv] !=color:
                continue
            visited[du][dv] = 1
            q.append((du, dv))

    return lst




# #격자 중력 작용 함수 만들기
def gravity():
    # 검은색 블록을 제외한 모든 블록이 행의 번호가 큰 칸으로 이동
    # (-1 제외하고 아래로 끌어내리기)

    for c in range(n):
        nr = n - 1
        r = n-1
        while r>0:
            if arr[r][c] !=-2:
                r-=1
                continue

            nr = min(r-1, nr)
            while nr>=0 and arr[nr][c]==-2:
                nr -=1


            if arr[nr][c]!=-1 and nr >=0:
                arr[r][c] = arr[nr][c]
                arr[nr][c] = -2

            r-= 1

def rotate_arr():
    return list(map(list, zip(*arr[::-1])))

def find_rainbow(lst):
    result = 0
    for i, j in lst:
        if arr[i][j] == 0:
            result+=1
    return result
#입력받기

dir = (-1, 0), (0, 1), (1, 0), (0, -1)
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
# cnt = 0
score = 0
while 1:
    #############################3이거 지워야해
    # cnt += 1
    # if cnt==2:
    #     break
    ##########################################3
    #block setting 한다
    blocks = []
    set_block()
    if not blocks:
        break
    # print(blocks)
    #블록 세팅 검증 완료


    # 1. 크기가 가장 큰 블록 그룹을 찾는다.
    #   우선순위\
    # 크기가 가장큰 그룹
    #       무지개 블록의 수가 가장 많은 블록 그룹
    #       기준 블록의 행이 가장 큰 것
    #       기준 블록의 열이 가장 큰 것
    blocks.sort(reverse=True, key = lambda x : (len(x[1]),find_rainbow(x[1]), x[0][0], x[0][1]))
    # print("==================블록 목록 ====================")
    #
    # for i in range(len(blocks)):
    #
    #     print(blocks[i])
    #
    # print()

    big_block = blocks[0][1]
    #
    # print("==================제거할 블록 ====================")
    # print(big_block)
    # 2. 1에서 찾은 블록 그룹의 모든 블록을 제거. 점수 += 블록수**2
    score += len(big_block)**2
    # print("============점수추가 ============")
    # print(len(big_block)**2)
    for y, x in big_block:
        arr[y][x] = -2

    # print("-----------제거 확인 -------------")
    # for i in range(n):
    #     print(arr[i])
    # 3. 격자에 중력이 작용
    gravity()
    #
    # print("-----------중력 작용 확인 -------------")
    # for i in range(n):
    #     print(arr[i])
    #
    # print()
    #
    # # 4. 격자가 90도 반시계 방향으로 회전한다.
    # arr = [ i[::-1] for i in list(map(list, zip(*arr[::-1])))]

    for i in range(3):
        arr = rotate_arr()

    # print("-----------회전 작용 확인 -------------")
    # for i in range(n):
    #     print(arr[i])
    #
    # print()

    gravity()


    # 5. 다시 격자에 중력이 작용한다.
    # print("-----------중력 작용 확인 -------------")
    # for i in range(n):
    #     print(arr[i])
    #
    # print()
print(score)



