"""
1502 문제 이해 및 간략 구상 완
1515 구현완
1520 디버깅 완 (bfs continue조건 rank값 실수)
1521 n,m범위실수..
1525 visited 처리 방식을 최댓값 기록으로 바꿔서 최단거리 방문 순서에 따라 고르지 못하는 경우 고려하도록 수정
1534 bfs로 풀던 풀이에서 visited방식을 방문처리로도, 최댓값 처리로도 어려움을 겪어 dfs로 재구현 후 제출
1537 dfs 종료 조건에 return 빼먹는 바보 나야나 ~
1544 백준은 시초가 난다 .. bfs rank로 visited기록하면 되겠다ㄱ는 아이디어 생각남@

==================구상=================
문제는 ㅏ ㅓ ㅗ ㅜ  모양
이 모양 제외 bfs or dfs 로 최댓값 찾기
bfs로 했을 때 겹치는 모양이 없을지 고려해볼것. 있겠군. 하지만 합이 최대인 경우니까 괜찮을듯

ㅏ ㅓ ㅗ ㅜ 는 분기문으로 해결하자


"""


# from collections import deque
# def bfs(r, c):
#     global answer
#     q = deque([(r, c, 1, arr[r][c])])
#     visited = [[0] * m for _ in range(n)]
#     visited[r][c] = 1
#     # sm_v = [[0] * m for _ in range(n)]
#     # sm_v[r][c] = arr[r][c]
#     while q:
#         i, j, rank, sm = q.popleft()
#         if rank==3:
#             #갱신
#             for di, dj in (-1, 0), (0, -1), (1, 0), (0, 1):
#                 du = r + di
#                 dv = c + dj
#                 if du < 0 or dv < 0 or du >= n or dv >= m:
#                     continue
#                 if not visited[du][dv] or visited[du][dv]==rank:
#                     visited[du][dv] = rank
#                     answer = max(answer, sm+arr[du][dv])
#             continue
#             # answer = max(answer, sm)
#             continue
#         for di, dj in (0, -1), (1, 0), (0, 1):
#             du = i+di
#             dv = j+dj
#             if du<0 or dv<0 or du>=n or dv>=m:
#                 continue
#             if visited[du][dv] < rank:
#                 continue
#             if not visited[du][dv] or visited[du][dv]==rank:
#                 visited[du][dv] = rank
#                 q.append((du, dv, rank+1, sm+arr[du][dv]))
import sys
sys.setrecursionlimit(100000)
def dfs(level, sm, r, c):
    global answer

    if level == 4:
        answer = max(answer, sm)
        # for i in range(n):
        #     print(visited[i])
        # print()
        return
    for di, dj in (-1, 0), (0, -1), (1, 0), (0, 1):
        du = r + di
        dv = c + dj
        if du < 0 or dv < 0 or du >= n or dv >= m:
            continue
        if not visited[du][dv] or visited[du][dv] >= level+1:
            visited[du][dv] = level+1
            dfs(level + 1, sm + arr[du][dv], du, dv)
            visited[du][dv] = 0


n, m = map(int, input().split())

arr = [list(map(int, input().split())) for i in range(n)]
answer = 0
visited = [[0] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if visited[i][j]:
            continue
        visited[i][j] = 1
        dfs(1, arr[i][j], i, j)
        visited[i][j] = 0

    # bfs(i, j)

# ㅏ ㅓ ㅗ ㅜ 체크
# 가운데 갈림길인 부분을 기점으로 보겟음
for i in range(n):
    for j in range(m):
        s = arr[i][j]
        # ㅏ / ㅓ
        if i + 1 < n and i - 1 >= 0 and j - 1 >= 0:  # ㅓ
            answer = max(answer, s + arr[i + 1][j] + arr[i - 1][j] + arr[i][j - 1])
        if i + 1 < n and i - 1 >= 0 and j + 1 < m:  # ㅏ
            answer = max(answer, s + arr[i + 1][j] + arr[i - 1][j] + arr[i][j + 1])
        if j + 1 < m and j - 1 >= 0 and i - 1 >= 0:  # ㅗ
            answer = max(answer, s + arr[i][j + 1] + arr[i][j - 1] + arr[i - 1][j])
        if j + 1 < m and j - 1 >= 0 and i + 1 < n:  # ㅗ
            answer = max(answer, s + arr[i][j + 1] + arr[i][j - 1] + arr[i + 1][j])
        # if i + 1 < n and j + 1 < m:
        #     answer = max(answer, s + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1])
print(answer)
