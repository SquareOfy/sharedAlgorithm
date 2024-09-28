"""
아리는 가장 왼쪽 위인 (1, 1)에서 출발
아리와 학생 좀비들은 모두 아래 방향을 보고 있다
F는 앞으로 1칸 전진
L은 아리가 현재 바라보고 있는 방향을 기준으로 왼쪽으로 90도 방향 전환
R은 오른쪽으로 90도 방향을 전환


형광등 스위치가 있는 칸에 도착하면
그 곳에 학생 좀비가 있더라도 학생 좀비랑 마주치기 전에 스위치를 켠다.

스위치를 켜게 되면 해당 스위치가 있는 칸과 상, 하, 좌, 우, 대각선 네 방향으로 1칸씩 불을 밝힌다.
스위치는 한 번 켜게 되면 꺼지지 않는다.


아리가 이동을 마칠 때마다 학생 좀비들은 자신이 보고 있는 방향으로 한 칸 전진한다
만약 학생 좀비들이 벽에 부딪히게 되면 제자리에서 뒤를 돌아 반대 방향을 바라본다.

"""


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= N


def printa(string, arr):
    print(f"===================={string}===================")
    for k in range(N):
        print(arr[k])


def turn_on_light(i, j):
    for di, dj in diagonal:
        du = i + di
        dv = j + dj
        if oob(du, dv):
            continue
        if visited[du][dv] == -1:
            continue
        visited[du][dv] = 1


def move_zombie():
    global answer
    new_zombie_arr = [[[] for _ in range(N)] for _ in range(N)]
    for z in range(1, len(zombie_lst)):
        zr, zc, zd = zombie_lst[z]

        zdi, zdj = DIR[zd]
        nzr, nzc = zr + zdi, zc + zdj
        if oob(nzr, nzc):
            zombie_lst[z] = [zr, zc, (zd + 2) % 4]
            new_zombie_arr[zr][zc].append(z)
            continue

        new_zombie_arr[nzr][nzc].append(z)
        zombie_lst[z] = [nzr, nzc, zd]
        if nzr == r and nzc == c and not visited[r][c]:
            answer = 'Aaaaaah!'
            return True

    for n in range(N):
        for m in range(N):
            zombie_arr[n][m] = new_zombie_arr[n][m][:]
    return False


def check(i, j, zombie_arr):
    if zombie_arr[i][j] and not visited[i][j]:
        return True
    return False


N = int(input())
order_lst = list(input())
arr = [list(input()) for _ in range(N)]
zombie_arr = [[[] for _ in range(N)] for _ in range(N)]
visited = [[0] * N for _ in range(N)]
zombie_lst = [0]
r, c, d = 0, 0, 2
DIR = [(-1, 0), (0, 1), (1, 0), (0, -1)]
diagonal = [(-1, -1), (-1, 1), (1, -1), (1, 1)] + DIR

for i in range(N):
    for j in range(N):
        if arr[i][j] == 'Z':
            zombie_arr[i][j].append(len(zombie_lst))
            zombie_lst.append([i, j, 2])
        elif arr[i][j] == 'S':
            visited[i][j] = -1

answer = "Phew..."
for o in order_lst:
    if o == 'L':
        d = (d - 1) % 4
    elif o == 'R':
        d = (d + 1) % 4
    else:
        di, dj = DIR[d]
        du, dv = r + di, c + dj
        if not oob(du, dv):
            r, c = du, dv
            if visited[du][dv] == -1:  # 스위치만나면
                visited[du][dv] = 1
                turn_on_light(du, dv)

            elif check(r, c, zombie_arr):
                answer = 'Aaaaaah!'
                break

    # printa("아리 이동 후 ", arr)
    # print('아리 위치 : ', r, c, d)
    # print()
    # printa("아리 이동 후 visited", visited)

    if zombie_arr[r][c] and not visited[r][c]:
        answer = 'Aaaaaah!'
        break

    # printa("좀비 이동 후 ", arr)
    if move_zombie():
        break

print(answer)