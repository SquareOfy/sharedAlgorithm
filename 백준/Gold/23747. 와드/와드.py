"""
R, C 배열
인덱스 1부터 시작!!!!!!!!!!!!!

상하좌우를 볼 수 있고 와드 설치 시, 그 칸이 속한 영역의 모든 칸을 볼 수 있게 됨
영역 : 격자의 모든 칸은 어떤 영역 하나에 속함
같은 영역 => 상하좌우로 인접해있고 같은 문자

한별 위치가 주어지고 그 위치에서 여행기록 문자열 주어짐

문자열의 문자 의미
U 위
D 아래
L 왼
R 오른쪽

W 와드 설치

격자 벗어나는 경우 주어지지 않음
"""
from collections import deque
def oob(i, j):
    return i<0 or j<0 or i>=R or j>=C

def bfs(i, j):
    q = deque([(i, j)])
    sight[i][j]='.'

    while q:
        cr, cc = q.popleft()

        for di, dj in dir:
            du = cr+di
            dv = cc+dj
            if oob(du, dv):
                continue
            if arr[du][dv]==arr[i][j] and sight[du][dv]=='#':
                q.append((du,dv))
                sight[du][dv] = '.'

R, C = map(int, input().split())
arr= [list(input()) for _ in range(R)]

r, c = map(int, input().split())
r-=1
c-=1
travel = list(input())

d_dict = {'U':0, 'R':1, 'D':2, 'L':3}
dir = (-1, 0), (0, 1), (1, 0), (0, -1)
sight = [['#']*C for _ in range(R)]

for i in range(len(travel)):
    t = travel[i]
    if t=='W':
        if sight[r][c] == '.':
            continue
        bfs(r,c)
    elif t in 'URLD':
        di, dj = dir[d_dict[t]]
        r+=di
        c+=dj

sight[r][c]='.'
for di, dj in dir:
    if not oob(r+di, c+dj):
        sight[r+di][c+dj] = '.'
for i in range(R):
    print(''.join(sight[i]))