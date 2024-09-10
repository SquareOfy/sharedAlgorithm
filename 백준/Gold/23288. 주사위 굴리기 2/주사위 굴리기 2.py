"""

"""
from collections import deque
def obb(y, x):
    return y<0 or y>=n or x<0 or x>=m
def set_score_arr():
    for i in range(n):
        for j in range(m):
            if visited[i][j]:
                continue
            cnt =0
            lst = []
            q = deque([(i, j)])
            visited[i][j] = 1
            v = arr[i][j]
            while q:
                cr, cc = q.popleft()
                lst.append((cr, cc))
                cnt+=1
                for di, dj in directions:
                    du = cr + di
                    dv = cc + dj
                    if obb(du, dv) or visited[du][dv]:
                        continue
                    if arr[du][dv]==v:
                        q.append((du,dv))
                        visited[du][dv] = 1

            s = cnt*v if cnt !=0  else v
            for nr, nc in lst:
                score[nr][nc] = s

#입력
n, m, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
#방향 배열, 주사위 배열 세팅
side = [3, 5, 4, 2]  #동 남 서 북 순
directions = (0, 1), (1, 0), (0, -1), (-1, 0) #동남서북
d = 0 #동쪽 방향으로 시작
bottom = 6

#arr 자리별 점수 세팅
score = [[0]*m for _ in range(n)]
visited = [[0]*m for _ in range(n)]
set_score_arr()

# for i in range(n):
#     print(score[i])
# # 점수배열 체크 완


#주사위 굴리기 k번 시작
#시작 0, 0
r, c = 0, 0
answer = 0
for i in range(k):
    di, dj = directions[d]
    nr = r+di
    nc = c+dj

    #범위 벗어나는지 체크하고 벗어나면 방향 반대로
    if obb(nr, nc):
        d = (d+2)%4
        di, dj = directions[d]
        nr = r+di
        nc = c+dj
    #그 칸으로 이동(주사위 bottom, side 변동)
    r = nr
    c = nc
    side[(d+2)%4] = bottom
    bottom = side[d]
    side[d] = 7-side[(d+2)%4]

    #이동한 칸의 점수 answer에 더하기
    answer += score[r][c]

    #주사위 회전여부 판단

    # print(f"============={i}=================")
    # print(r+1, c+1)
    # print("회전 전 d : ", d)

    if bottom > arr[r][c]:
        d = (d+1)%4
    elif bottom < arr[r][c]:
        d = (d+3)%4
    # print(arr[r][c])
    # print("bottom : ", bottom)
    # print("회전 후 d : " , d)
    # print(score[r][c])
    # print('=================================')
print(answer)