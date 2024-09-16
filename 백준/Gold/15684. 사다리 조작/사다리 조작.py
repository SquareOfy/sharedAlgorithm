"""
가로선을 나타내는 배열 만들기

i행 j열이 1이면 j번째 열과 j+1번째 열을 i행에서 연결하는 가로선..!
초기 입력값을 받아 1 ~ n 까지의 세로선에서 출발해서 도착하는 열을
arrived_lst 에 저장

arrived_lst[i]와 i의 관계
    arrived_lst[2] = 0
        : 0번 세로선에서 출발한게 2번 세로선에서 도착
        : arrived_lst[i] ~ i (range(0, 2))를 보며 그 라인 가로칸에
        가로칸 이미 추가했으면 continue.
        추가 안했고 다음에 만날 가로보다 행 값 더 낮은 칸에 추가 가능하면 추가.
        아니면 다음칸에 추가 가능한지 봐야함
available 로 가로선이 이미 있거나 양 옆에 있는경우 불가하다는 표시 해놓기.
    하지만 이렇게 하면 앞에 선택한 값이 뒤에도 영향을 주어 확신이 서지 않는다.
그리디하게는 어렵겠다. 위 방법으로 백트래킹 돌자 !!
    arrived_lst[i]에서 선을 놓을 때
    arrived_lst[i]+1에서 선 놓을 때

혹은 그냥 사다리 추가 한개 해보기
두개 해보기
3개 해보기...

시간복잡도 : 300개 중 1개 + 300개 중 2개 300개 중 3개
        Combi 로 해야 가능할 것 같다
        2차원이니까
        i, j 를 선택하고 나면 i, j+1부터 보도록 하고 ! 그 다음 i+1부터 다 보기
        j+1이 마지막이면 i+1, 0부터 보도록 하기


"""

import sys
sys.setrecursionlimit(10000)


def dfs(level, si, sj):
    global answer
    #이미 찾았으면
    if level >= answer or level == 4:
        return

    # down = (garo)
    # if check(down):down_ladder
    #     answer = level
    #     return
    if check_down_ladder():
        answer = level
        return

    #선택할 가로 사다리 탐색
    for j in range(sj, N):
        if garo[si][j]: continue
        if (j-1>=1 and garo[si][j-1]) or (j+1<N and garo[si][j+1]):
            continue
        garo[si][j] = 1
        nj = j+1 if j<N else 1
        ni = si if nj!=1 else si+1
        #여기 선택했으니 다음 선택 하러가기
        dfs(level+1, ni, nj)
        garo[si][j] = 0

    #아랫 줄도 보기
    for i in range(si+1, H+1):
        for j in range(1, N):
            if garo[i][j]:
                continue
            #왼쪽이나 오른쪽에 이미 가로선이 있으면
            if (j - 1 >= 1 and garo[i][j - 1]) or (j + 1 < N and garo[i][j + 1]):
                continue
            garo[i][j] = 1
            nj = j + 1 if j < N else 1
            ni = i if nj != 1 else i + 1
            # 여기 선택했으니 다음 선택 하러가기
            dfs(level + 1, ni, nj)
            garo[i][j]=0

def check_down_ladder():
    for i in range(1, N+1): #출발 세로선 번호
        sero = i
        for j in range(1, H+1):
            if sero<N and garo[j][sero]:
                sero+=1
                # print("오른쪽 이동")
            elif sero-1>=1 and garo[j][sero-1]:
                sero -=1
        if sero!=i:
            return False
    return True


# def check(down):
#     for i in range(1, N):
#         if down[i] != i:
#             return False
#     return True
#세로선 개수, 입력되는 가로선 개수, 세로선 마다 놓을 수 있는 위치의 개수(행 값)
N, M, H = map(int, input().split())

garo = [[0]*(N) for _ in range(H+1)]

#불가능한 곳 0으로 바꾸기
for i in range(M):
    #b번세로선과 b+1번 세로선을 a번 점선 위치에서 연결
    a, b = map(int, input().split())
    garo[a][b] = 1

if check_down_ladder():
    print(0)
else:
    answer = 4
    dfs(0, 1, 1)
    print(answer if answer<4 else -1)