from collections import deque


# bfs 구현

def bfs(i, j):
    q = deque([(i, j)])
    visited[i][j] = 1
    lst = [(i, j)]

    while q:
        cr, cc = q.popleft()
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du, dv = cr + di, cc + dj
            if du < 1 or du > N: continue  # 원판은 1, N 연결 안됨
            dv %= M

            if visited[du][dv] or arr[du][dv] != arr[i][j]: continue
            visited[du][dv] = 1
            q.append((du, dv))
            lst.append((du, dv))

    if len(lst) > 1:
        for r, c in lst:
            arr[r][c] = -1
    return len(lst) - 1


# 입력 / 배열 준비
N, M, Q = map(int, input().split())
arr = [-1] + [deque(list(map(int, input().split()))) for _ in range(N)]

# for 문 (Q번 진행)
for q in range(Q):
    # 입력
    x, d, k = map(int, input().split())
    d = 1 if d == 0 else -1
    # 회전시키기
    for t in range(x, N + 1, x):
        # print(k)
        arr[t].rotate(d * k)

    # print("==============회전 테스트 ==================")
    # print(x, d, k)
    # for t in range(1, N+1):
    #     print(arr[t])
    # print("=========================================")

    # 인접 같은 숫자 삭제 -> BFS 활용 . -1 로 만들기
    # 삭제 여부 flag 활용
    flag = False
    visited = [[0] * M for _ in range(N + 1)]
    for i in range(1, N + 1):
        for j in range(M):
            if not visited[i][j] and arr[i][j] != -1:
                result = bfs(i, j)
                if result: flag = 1

    # print("==============수 지우기 테스트 =====================")
    # for t in range(1, N+1):
    #     print(arr[t])
    # print("==============================================")

    # 삭제된 적 없으면 정규화를 위한 평균 구하기
    if flag: continue
    s = 0
    cnt = 0
    for i in range(1, N + 1):
        for j in range(M):
            if arr[i][j] == -1:
                continue
            cnt += 1
            s += arr[i][j]
    # cnt == 0 이면 정규화 안함
    if cnt == 0: break
    # 정규화하기
    arr_mean = s / cnt
    # print("평균 : ", s//cnt)
    for i in range(1, N + 1):
        for j in range(M):
            if arr[i][j] == -1: continue
            if arr[i][j] > arr_mean:
                arr[i][j] -= 1
            elif arr[i][j] < arr_mean:
                arr[i][j] += 1
    # print()
    # for t in range(1, N+1):
    #     print(arr[t])
ans = 0
for i in range(1, N + 1):
    for j in range(M):
        if arr[i][j] == -1: continue
        ans += arr[i][j]


print(ans)