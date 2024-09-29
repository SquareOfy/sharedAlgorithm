"""
문서의 위치를 나타내는 평면도
열쇠 일부 가지고 있고 나머지는 바닥에 놓여짐
상하좌우만 이동 가능
상근이가 훔칠 수 있는 문서의 최대개수


. 빈공간
* 벽
$ 문서
대문자 문
소문자 열쇠

마지막 줄에는 상근이가 이미 가지고 있는 열쇠가 공백없이 주어진다

열쇠를 하나도 가지고 있지 않는 경우에는 "0"이 주어진다.
상근이는 처음에는 빌딩의 밖에 있으며,
 빌딩 가장자리의 벽이 아닌 곳을 통해 빌딩 안팎을 드나들 수 있다.


"""

"""
색종이 붙이기 
백트래킹 

1인곳에 1*1 ~ 5*5까지 사각형 맞는지 보고 맞으면 붙여보고 넘어가기
이 때 5*5 로 하고 필요한 사각형 개수가 answer보다 크면 바로 return해서 가지치기 


"""


def check(r, c, l):
    for i in range(r, r + l):
        for j in range(c, c + l):
            if arr[i][j] == 0:
                return False
    return True


def change_arr(r, c, l, num):
    for i in range(r, r + l):
        for j in range(c, c + l):
            arr[i][j] = num



def find_next_rc(r, c, l):
    if c + l != 10:
        for j in range(c + l, 10):
            if arr[r][j] == 1:
                return r, j

    for i in range(r + 1, 10):
        for j in range(10):
            if arr[i][j] == 1:
                return i, j
    return -1, -1


def dfs(level, r, c):
    global answer, one_cnt
    if answer <= level:
        return
    if one_cnt == 0:
        answer = min(answer, level)
        return

    for l in range(5, 0, -1):
        if r+l>10 or c+l>10: continue
        if not check(r, c, l): continue
        if paper_cnt[l] == 0: continue
        change_arr(r, c, l, 0)
        one_cnt -= (l * l)
        paper_cnt[l] -= 1
        nr, nc = find_next_rc(r, c, l)
        dfs(level + 1, nr, nc)
        change_arr(r, c, l, 1)
        paper_cnt[l] += 1
        one_cnt += (l * l)


arr = [list(map(int, input().split())) for _ in range(10)]

# 1인 칸 미리 넣어두기
one_lst = []
one_cnt = 0
inf = 101
answer = inf
paper_cnt = [5] * 6
fr, fc = -1, -1
for i in range(10):
    for j in range(10):
        if arr[i][j] == 1:
            one_cnt += 1
            if fr == -1:
                fr, fc = i, j
dfs(0, fr, fc)
print(answer if answer != inf else -1)