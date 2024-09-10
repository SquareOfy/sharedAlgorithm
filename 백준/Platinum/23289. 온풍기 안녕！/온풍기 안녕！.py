


"""
주의사항
- R,C
- 온풍기 바람 이동 시 벽 (대각도 벽에 막힘)
- 온도 조절은 동시에
"""
def higher_k():
    for i in range(R):
        for j in range(C):
            if arr[i][j] == 5 and temp[i][j] < K:
                return False
    return True

def oob(r, c):
    return r<0 or r>=R or c<0 or c>=C
def blow(r, c, d):
    dir = directions[d]
    di, dj = dir[1]
    # 5부터 시작
    nr = r+di
    nc = c+dj
    temp[nr][nc] += 5
    visited[nr][nc] = 1
    blow_split(nr, nc, dir, d, 4)


def blow_split(r, c, dirs, d, k):
    if k ==0 :
        return
    for di, dj in dirs:
        nr = r+di
        nc = c+dj
        if oob(nr, nc):
            continue
        if visited[nr][nc]:
            continue
        #벽 체크
        #직선 방향이면

        if di==0 or dj==0:
            if d in wall[r][c]:
                continue
        #좌우를 보고 있고 대각일 때
        elif d%2 !=0:
            # 상 우 하 좌
            if r-1 >= 0 and di==-1 and (2 in wall[r-1][c] or d in wall[r-1][c]):
                continue
            if r+1<R and di == 1 and (0 in wall[r+1][c] or d in wall[r+1][c]):
                continue
        #상하를 보고 있고 대각일때
        else:
            if c-1>=0 and dj == -1 and (1 in wall[r][c-1] or d in wall[r][c-1]):
                continue
            if c+1<C and dj == 1 and (3 in wall[r][c+1] or d in wall[r][c+1]):
                continue

        temp[nr][nc] += k
        visited[nr][nc] = 1
        blow_split(nr, nc, dirs, d, k - 1)


R, C, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(R)]
W = int(input())
wall = [[[] for _ in range(C)] for i in range(R)]
temp = [[0] *C for _ in range(R)]
#해당칸에서 벽이 있어서 못가는 칸 기록
for w in range(W):
    x, y, t = map(int, input().split())
    x -= 1
    y-=1
    if t == 0:
        wall[x][y].append(0)
        wall[x-1][y].append(2)
    else:
        wall[x][y].append(1)
        wall[x][y+1].append(3)
machine = []
dir_idx = [0, 1, 3, 0, 2]
for i in range(R):
    for j in range(C):
        if arr[i][j]!=0 and arr[i][j] != 5:
            d = dir_idx[arr[i][j]]
            machine.append((i, j, d))
answer = 0
#방향 상우하좌 별로 퍼지는 곳
directions = ((-1, -1), (-1, 0), (-1, 1)), \
    ((-1, 1), (0, 1), (1, 1)), \
    ((1, -1), (1, 0), (1, 1)), \
    ((-1, -1), (0, -1), (1, -1))
tmp = [[0] * C for _ in range(R)]

while 1:
    answer += 1
    #온풍기에서 바람나오기
    for i, j, d in machine:
        visited = [[0]*C for _ in range(R)]
        blow(i, j, d)


    #온도 조절 #임의 배열 만들어서 동시에 반영
    for i in range(R):
        for j in range(C):
            for di, dj in (1, 0), (0, 1):
                if (di, dj) == (1, 0) and 2 in wall[i][j]:
                    continue
                if (di, dj) == (0, 1) and 1 in wall[i][j]:
                    continue
                ni = i+di
                nj = j+dj
                if oob(ni, nj):
                    continue

                gap = abs(temp[i][j]- temp[ni][nj])//4
                if temp[i][j] < temp[ni][nj]:
                    tmp[i][j]+= gap
                    tmp[ni][nj] -= gap
                else:
                    tmp[i][j]-= gap
                    tmp[ni][nj] += gap
    for i in range(R):
        for j in range(C):
            temp[i][j] += tmp[i][j]
            tmp[i][j] = 0


    #바깥 온도 1씩 감소
    for i in range(1, R-1):
        temp[i][0]= max(temp[i][0]-1, 0)
        temp[i][C-1] = max(temp[i][C-1]-1, 0)
    for j in range(1, C-1):
        temp[0][j] = max(temp[0][j]-1, 0)
        temp[R-1][j] = max(temp[R-1][j]-1, 0)
    temp[0][0] = max(temp[0][0]-1, 0)
    temp[0][C-1] = max(temp[0][C-1]-1, 0)
    temp[R-1][0] = max(temp[R-1][0]-1, 0)
    temp[R-1][C-1] = max(temp[R-1][C-1]-1, 0)

    #온도 조사(5인 칸이 모두 K 이상)
    if higher_k() or answer >=101:
        break

print(answer)