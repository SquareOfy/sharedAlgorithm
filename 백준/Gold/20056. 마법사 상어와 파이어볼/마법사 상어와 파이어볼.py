N, M, K = map(int, input().split())
arr = [[[] for _ in range(N)] for _ in range(N)]
DIR = (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)
for m in range(M):
    x, y, m, s, d = map(int, input().split())
    x -= 1
    y -= 1
    arr[x][y].append((m, s, d))
# print("=================초기 상태 ==================")
# for t in range(N):
#     print(arr[t])
# print("=============================================")
for k in range(K):
    tmp = [[[] for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not arr[i][j]: continue
            # print(arr[i][j])
            for t in range(len(arr[i][j])):
                m, s, d = arr[i][j][t]
                nr = (i + DIR[d][0] * s) % N
                nc = (j + DIR[d][1] * s) % N
                tmp[nr][nc].append((m, s, d))
    for i in range(N):
        for j in range(N):
            if len(tmp[i][j]) < 2: continue
            mm = 0
            ss = 0
            multiple_d = 1
            sum_d = 0
            for m, s, d in tmp[i][j]:
                mm += m
                ss += s
                multiple_d *= (d%2)
                sum_d += (d%2)

            new_m = mm//5
            new_s = ss//len(tmp[i][j])
            tmp[i][j] = []
            if new_m ==0:
                continue
            new_d = [0, 2, 4, 6] if sum_d==0 or multiple_d==1 else [1, 3, 5, 7]

            for k in range(4):
                tmp[i][j].append((new_m, new_s, new_d[k]))



    for i in range(N):
        for j in range(N):
            arr[i][j] = tmp[i][j][:]
    #     print(arr[i])
    # print("======================================")

answer = 0
for i in range(N):
    for j in range(N):
        for m, s, d in arr[i][j]:
            answer+= m

print(answer)