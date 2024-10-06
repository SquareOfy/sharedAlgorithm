"""

n x n으로 이뤄진 나선형 미로
1. 플레이어는 상하좌우 방향 중 주어진 공격 칸 수만큼 몬스터를 공격하여 없앨 수 있습니다.
2. 비어있는 공간만큼 몬스터는 앞으로 이동하여 빈 공간을 채웁니다.

3. 이때 몬스터의 종류가 4번 이상 반복하여 나오면 해당 몬스터 또한 삭제됩니다. 해당 몬스터들은 동시에 사라집니다.
    삭제된 이후에는 몬스터들을 앞으로 당겨주고,
    4번 이상 나오는 몬스터가 있을 경우 또 삭제를 해줍니다.
    4번 이상 나오는 몬스터가 없을 때까지 반복해줍니다.

4. 삭제가 끝난 다음에는 몬스터를 차례대로 나열했을 때 같은 숫자끼리 짝을 지어줍니다.
    이후 각각의 짝을 (총 개수, 숫자의 크기)로 바꾸어서 다시 미로 속에 집어넣습니다.
    새로 생긴 배열이 원래 격자의 범위를 넘는다면 나머지 배열은 무시

1과 3 과정에서 삭제되는 몬스터의 번호는 점수에 합쳐집니다.
모든 라운드가 끝난 후 플레이어가 얻게되는 점수

"""


# 달팽이 준비 함수
def make_route_arr():
    r, c = N // 2, N // 2
    l = 1
    cnt = 0

    while 1:
        for di, dj in (0, -1), (1, 0), (0, 1), (-1, 0):
            for t in range(l):
                r += di
                c += dj
                route_lst.append((r, c))
                if r == 0 and c == 0:
                    return
            cnt += 1
            if cnt == 2:
                l += 1
                cnt = 0


# 배열 당기는 함수
def pull_arr():
    for i in range(N * N - 1):
        r, c = route_lst[i]
        # 당길 숫자 찾기 !!
        if arr[r][c] == 0:
            nk = i + 1
            while nk < N * N - 1:
                nr, nc = route_lst[nk]
                if arr[nr][nc] != 0:
                    break
                nk += 1
            if nk < N * N - 1 and arr[nr][nc] != 0:
                arr[r][c] = arr[nr][nc]
                arr[nr][nc] = 0
            else:
                return


# 같은 숫자 탐색해서 개수 반환
def find_cnt(i):
    r, c = route_lst[i]
    num = arr[r][c]
    cnt = 1
    for j in range(i + 1, N * N - 1):
        nr, nc = route_lst[j]
        if num != arr[nr][nc]:
            return cnt
        cnt += 1
    return cnt


# 입력
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
route_lst = []
make_route_arr()
DIR = (-1, 0), (1, 0), (0, -1), (0, 1)
sr, sc = N // 2, N // 2
answer = [0] * 4

for m in range(M):
    d, p = map(int, input().split())
    d -= 1
    di, dj = DIR[d]
    nr, nc = sr, sc

    # 1번 죽이기
    for t in range(p):
        nr += di
        nc += dj
        if nr < 0 or nc < 0 or nr >= N or nc >= N: continue
        # answer[arr[nr][nc]] += 1
        arr[nr][nc] = 0
    # 죽인후 당기기
    pull_arr()

    while 1:
        flag = False
        for i in range(N * N - 1):
            cr, cc = route_lst[i]
            if arr[cr][cc] == 0: continue
            cnt = find_cnt(i)
            if cnt >= 4:
                for t in range(cnt):
                    r, c = route_lst[i + t]
                    answer[arr[r][c]] += 1
                    arr[r][c] = 0
                    flag = True
        if not flag:
            break

        pull_arr()

    # 숫자 새로 매기기
    new_lst = []
    for i in range(N * N - 1):
        r, c = route_lst[i]
        if arr[r][c] == 0: continue
        cnt = find_cnt(i)
        new_lst.extend([cnt, arr[r][c]])
        if len(new_lst) >= N * N - 1:
            new_lst = new_lst[:N * N]
            break
        for t in range(cnt):
            nr, nc = route_lst[i + t]
            arr[nr][nc] = 0

    arr = [[0] * N for _ in range(N)]
    for i in range(len(new_lst)):
        nr, nc = route_lst[i]
        arr[nr][nc] = new_lst[i]

ans = 0
for i in range(1, 4):
    ans += i * answer[i]
print(ans)