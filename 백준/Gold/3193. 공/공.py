"""

N*N
구역 빈칸 or 벽
빈칸 중 한 곳 공 -> 중력 영향으로 벽이나 게임판 바닥 위

시계 또는 반시계로 90도 회전 => 벽, 공도 함께 회전 (배열회전 쓰면 됨)
회전 후 중력 영향으로 바닥, 벽 만날 땔까지 떨어짐

초기 공 : L
명령 
L : 반시계 90도 회전
R : 시계 90도 회전

str size = 50byte
50 * 10**6 = 50MB


시간 초과 남 ;;
각 위치별로 L할 때 R할 때 어디로 가는지 배열에 저장하고 gravity 안쓰고 바로 가기

메모리
int size = 28 byte
dp 배열 1000*1000*2*2
2*56*10**6 = 112MB

안되는데 ................? 앗 ,,

일단 제끼고 방향 돌리기부터 방법 바꾸자
지금 나한테 중력이 작용하는 방향을 기억하자. 그리고 반시계, 시계 돌릴 때 이 방향을 바꾸는거지


"""


# def rotate(o):
#     if o == 'L':
#         return list(map(list, zip(*arr)))[::-1]
#     else:
#         return list(map(list, zip(*arr[::-1])))
#
#
# def rotate_ball_point(o):
#     if o == 'L':
#         return n - 1 - c, r
#
#     return c, n - 1 - r
def oob(i, j):
    return i<0 or j<0 or i>=n or j>=n

def gravity():
    global r, c
    # if visited[r][c]
    # r, c를 아래를 보며 바닥이 있는 곳까지 찾기
    if dp[r][c][d] != -1:
        if d in (0, 2):
            return dp[r][c][d], c
        else:
            return r, dp[r][c][d]
    arr[r][c] = '.'
    du = r
    dv = c
    di, dj = dir[d]
    while 1:
        du+=di
        dv+=dj
        if oob(du, dv) or arr[du][dv] =='X':
            du-=di
            dv-=dj
            break
    if d in (0, 2):
        dp[r][c][d] = du
    else:
        dp[r][c][d] = dv
    return du, dv


n, k = map(int, input().split())
arr = [list(input()) for _ in range(n)]
dir = (1, 0), (0, 1), (-1, 0), (0, -1)
d = 0  # 현재 중력방향 L이면 -1 , D이면 +1됨
dp = [[[-1]*4 for _ in range(n)] for _ in range(n)]

r, c = -1, -1

# 처음 공 찾기!
for i in range(n):
    for j in range(n):
        if arr[i][j] == 'L':
            r, c = i, j
arr[r][c] = '.'
for i in range(k):
    order = input()
    if order == 'L':
        d = (d - 1) % 4
    else:
        d = (d + 1) % 4
    r, c = gravity()


arr[r][c] = 'L'
if d>0:
    for i in range(d):
        arr = list(map(list, zip(*arr[::-1])))
for i in range(n):
    print(''.join(arr[i]))