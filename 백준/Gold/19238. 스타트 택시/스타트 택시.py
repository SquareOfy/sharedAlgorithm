"""
n * n 격자의 도로
차가 지나갈 수 없는 벽의 위치와 m명의 승객의 위치가 주어질 때

승객을 태우러 출발지에 이동할 때에나 태우고 목적지로 이동할 때 항상 최단 거리로 이동
자율주행 전기차는 한 칸을 이동할 때 1만큼의 배터리를 소요
승객을 목적지로 무사히 태워주면 그 승객을 태워서 이동하며
소모한 배터리 양의 두 배만큼을 충전한 뒤 다시 이동
이동하는 도중에 배터리가 모두 소모되면 그 즉시 종료

만일 승객을 목적지로 이동시킨 동시에 배터리가 모두 소모되는 경우에는
 승객을 태우며 소모한 배터리의 두 배만큼 충전되어 다시 운행을 시작할 수 있습니다.

 승객이 여러명일 경우 현재 위치에서 최단 거리가 가장 짧은 승객을 먼저
 만약 그런 승객이 여러 명일 경우에는 가장 위에 있는 승객을,
 그런 승객이 여러 명일 때는 가장 왼쪽에 있는 승객을

"""
from collections import deque


def oob(i, j):
    return i < 0 or j < 0 or i >= N or j >= N


def find_passenger():
    q = deque([(tr, tc, 0)])
    visited = [[0] * N for _ in range(N)]
    visited[tr][tc] = 1
    pr, pc = N, N
    dist = N * N
    while q:
        cr, cc, rank = q.popleft()
        if arr[cr][cc] < 0:
            if dist > rank:
                dist = rank
                pr, pc = cr, cc
            elif dist == rank and (pr, pc) > (cr, cc):
                pr, pc = cr, cc
                dist = rank
            continue
        for di, dj in DIR:
            du, dv = cr + di, cc + dj
            if oob(du, dv) or arr[du][dv] == 1 or visited[du][dv]:
                continue

            q.append((du, dv, rank + 1))
            visited[du][dv] = 1
    return pr, pc, dist


def bfs_to_goal(sr, sc, idx):
    gr, gc = p_info[idx]
    result = -1
    q = deque([(sr, sc, 0)])
    visited = [[0] * N for _ in range(N)]
    visited[sr][sc] = 1

    while q:
        cr, cc, rank = q.popleft()
        if cr == gr and cc == gc:
            return rank
        for di, dj in DIR:
            du, dv = cr + di, cc + dj
            if oob(du, dv) or visited[du][dv] or arr[du][dv] == 1:
                continue
            q.append((du, dv, rank + 1))
            visited[du][dv] = 1
    return result


def change_idx(i):
    return int(i) - 1


# 입력
N, M, C = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
tr, tc = map(change_idx, input().split())
p_info = [-1]
DIR = (-1, 0), (0, 1), (1, 0), (0, -1)
for m in range(1, M + 1):
    sr, sc, er, ec = map(change_idx, input().split())
    arr[sr][sc] = -m
    p_info.append((er, ec))

# for문
for m in range(M):
    # 태울 승객 찾기
    pr, pc, rank = find_passenger()

    # 못찾거나 C <0 가 되면 ans -1로 바꾸고 break
    if pr == N or C - rank < 0:
        C = -1
        break

    # 승객 태워다주기
    C -= rank
    idx = -arr[pr][pc]
    gr, gc = p_info[idx]
    dist = bfs_to_goal(pr, pc, idx)
    arr[pr][pc] = 0
    p_info[idx] = -1

    # 못태워다주거나 C<0 되면 BREAK
    if dist == -1 or C - dist < 0:
        C = -1
        break
    C += dist
    tr, tc = gr, gc

print(C)
