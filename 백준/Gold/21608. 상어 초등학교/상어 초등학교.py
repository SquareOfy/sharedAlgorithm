"""

자리 정하기 규칙
1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로
    자리를 정한다.
3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로,
    그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.


학생 순서대로 자리 정하기
1. 빈칸 중 인접한 칸의 좋아하는 학생 수 세기 + 빈칸 수 세기
2. 좋아하는 학생 수가 많은 칸대로 SORT + 빈칸 수 + 행렬 순
가장 앞 칸에 학생 넣기

위 과정 반복 ..


다 앉히고 만족도 구하기
인접 칸에 앉은 좋아하는 학생 수의 합

시간복잡도는?
N*N*NlogN
"""

dir = (-1, 0), (0, 1), (1, 0), (0, -1)
n = int(input())
arr = [[0]*n for _ in range(n)]
favorite = {}
for i in range(n**2):
    num, *lst = list(map(int, input().split()))
    favorite[num] = lst

    blank_lst = []
    #arr 탐색하면서 빈자리 넣기
    for i in range(n):
        for j in range(n):
            if arr[i][j]==0:
                blank = 0
                like = 0
                #상하좌우로 빈칸과 좋아하는 친구 세기
                for di, dj in dir:
                    du = i+di
                    dv = j+dj
                    if du<0 or dv<0 or du>=n or dv>=n:
                        continue
                    if arr[du][dv] ==0:
                        blank+=1
                    elif arr[du][dv] in lst:
                        like+=1
                blank_lst.append((like, blank, i, j))

    blank_lst.sort(key = lambda x:(-x[0], -x[1], x[2], x[3]))
    r, c = blank_lst[0][2], blank_lst[0][3]
    arr[r][c] = num

good = 0

for i in range(n):
    for j in range(n):
        lst = favorite[arr[i][j]]
        like = 0
        for di, dj in dir:
            du = i+di
            dv = j+dj
            if du<0 or dv<0 or du>=n or dv>=n:
                continue
            if arr[du][dv] in lst:
                like+=1
        if like>0:
            good+= 10**(like-1)


print(good)