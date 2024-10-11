"""
무한히 큰 2차원 격자판
동굴은 N x M 크기
동굴 주위는 벽으로 막혀있으며, 동굴 곳곳에는 석순이 자라있다.

아리는 동굴 안의 격자판 중 한 칸에, 보스는 아리와 상하좌우 인접한 칸 중 한 칸에 위치한 상태
진행 방향은 상하좌우 네 방향 중 하나

전투가 시작될 때 보스의 진행 방향은 보스가 아리를 바라보고 있는 방향
아리의 첫 진행 방향도 보스의 진행 방향과 동일
아리와 보스 모두 동굴 벽이나 석순이 자란 칸으로 이동할 수 없으며,
둘이 동시에 한 칸에 있을 수는 없다.

 아리의 공격 - 아리의 이동 - 보스의 공격 - 보스의 이동
 상대의 공격으로 데미지를 입을 경우 자신의 체력이 입은 데미지만큼 감소
 전투 중 아리와 보스 둘 중 체력이 먼저 0 보다 작거나 같게 되는 쪽이 패배

 1. 아리 공격
    아리는 D만큼의 데미지로 보스를 한 번 공격
2. 아리 이동
    현재 진행 방향으로 한 칸 이동
    이동할 수 없는 경우, 이동할 수 있는 진행 방향을 찾을 때까지
    제자리에서 오른쪽으로 90도씩 회전
    회전할 때마다 체력을 1 소모
    4번을 회전하고도 진행 방향을 찾지 못한 경우 이동 안함

3. 보스 공격
    보스는 현재 위치한 칸을 중심으로 시계 방향으로 탐색을 진행
    석순을 하나 발견하거나 동굴 안의 모든 칸을 확인할 때까지 정사각형의 크기를 늘려가며 탐색을 진행
    석순 발견 못하면 공격 차례 끝
    석순을 발견했다면 발견한 석순이 위치한 칸에
    보스의 공격력인 E만큼의 체력을 가지는 부하 몬스터를 한 마리 소환
     아리에게 최단 거리로 이동하여 아리를 공격하고 사라짐
        몬스터  상하좌우로 한 칸씩 이동 가능
        한 칸 이동할 때마다 자신의 체력을 1 소모
        동굴 벽 혹은 보스나 석순이 위치한 칸으로 이동할 수 없다.
        아리가 있는 칸에 도착했을 때 남은 체력만큼 아리에게 데미지를 입히고 사라짐
        가는 도중 체력이 0이 되었거나 아리에게 도착할 수 없었다면
        부하 몬스터는 데미지를 입히지 못하고 사라짐

"""

from collections import deque


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= M


def find_submon(ir, ic, id):
    r, c = ir, ic
    l = 1
    rec_cnt = 0
    cnt = 0
    while 1:
        for dk in range(4):
            ndk = (id + dk) % 4
            di, dj = DIR[ndk]

            for t in range(l):
                r += di
                c += dj
                if oob(r, c): continue
                rec_cnt += 1
                if arr[r][c] == 1:
                    return 1, r, c
                if rec_cnt == N * M - 1:
                    return 0, N, N
            cnt += 1
            if cnt == 2:
                l += 1
                cnt = 0
    return 0, N, N


def bfs(mmr, mmc):
    q = deque([(mmr, mmc, mon_power)])
    visited = [[0] * M for _ in range(N)]
    visited[mmr][mmc] = 1

    while q:
        cr, cc, p = q.popleft()
        if p == 0 or arr[cr][cc] == 2:
            return p

        for di, dj in DIR:
            du, dv = cr + di, cc + dj
            if oob(du, dv): continue
            if visited[du][dv]: continue
            if arr[du][dv] == 1 or arr[du][dv] == 3:
                continue
            q.append((du, dv, p - 1))
            visited[du][dv] = 1
    return 0


DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
N, M = map(int, input().split())
mx = max(N, M)
arr = [list(map(int, input().split())) for _ in range(N)]

ari_hp, ari_power, mon_hp, mon_power = map(int, input().split())
br, bc = -1, -1

for i in range(N):
    for j in range(M):
        if arr[i][j] == 2:
            ar, ac = i, j
        elif arr[i][j] == 3:
            mr, mc = i, j

sub_mon_dict = {}

# for i in range(N):
#     for j in range(M):
#         for k in range(4):
#             flag, rr, rc = find_submon(i, j, k)
#             sub_mon_dict[(i, j, k)] = (flag, rr, rc)
# print(sub_mon_dict)
for i in range(4):
    di, dj = DIR[i]
    if oob(mr + di, mc + dj): continue
    if arr[mr + di][mc + dj] == 2:
        d = i
        break

ari_win = False

while 1:
    mon_hp -= ari_power
    if mon_hp <= 0:
        ari_win = True
        break
    # print("아리 공격 후 몬스터 피 : ", mon_hp)
    ari_move = False
    arr[ar][ac] = 0
    for k in range(4):
        nd = (d + k) % 4
        di, dj = DIR[nd]
        du, dv = ar + di, ac + dj

        if oob(du, dv) or arr[du][dv] == 1 or arr[du][dv] == 3:
            ari_hp -= 1
            continue
        ari_move = True
        br, bc = ar, ac
        ar, ac = du, dv
        break
    arr[ar][ac] = 2
    # print("========================아리 이동 후========================")
    #
    # print("ar, ac : ", ar, ac)
    # print("아리 피 : ", ari_hp)
    # print("d : ", d)
    # print("nd : ", nd)
    if ari_hp <= 0:
        break

    # flag, mmr, mmc = sub_mon_dict[(mr, mc, d)]
    flag, mmr, mmc = find_submon(mr, mc, d)
    # print(flag, mmr, mmc)
    if flag:
        power = bfs(mmr, mmc)
        ari_hp -= power

    if ari_hp <= 0:
        break

    if ari_move:
        arr[mr][mc] = 0
        mr, mc = br, bc
        arr[mr][mc] = 3
        d = nd
print("VICTORY!" if ari_win else "CAVELIFE...")
