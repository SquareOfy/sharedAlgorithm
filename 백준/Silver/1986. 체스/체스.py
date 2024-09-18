def oob(i, j):
    return i<=0 or j<=0 or i>N or j>M

N, M = map(int, input().split())
arr = [[0]*(M+1) for _ in range(N+1)]
queen = list(map(int, input().split()))
knight = list(map(int, input().split()))
pawn = list(map(int, input().split()))
q = queen[0]
k = knight[0]
p = pawn[0]
answer = N*M
for i in range(1, q*2, 2):
    r, c = queen[i], queen[i+1]
    arr[r][c] = 1
    answer -= 1

for i in range(1, k*2, 2):
    arr[knight[i]][knight[i+1]] = 2
    answer -=1

for i in range(1, p*2, 2):
    arr[pawn[i]][pawn[i+1]] = 3
    answer -= 1

for i in range(1, N+1):
    for j in range(1, M+1):
        if arr[i][j] ==1:
            # 상하좌우대각모두 확인
            for di, dj in (-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (1, 1), (-1, 1), (1, -1):
                # +할 때
                du, dv = i, j
                while 1:
                    du += di
                    dv += dj
                    if oob(du, dv) or arr[du][dv]> 0:
                        break
                    if arr[du][dv] == -1:
                        continue
                    arr[du][dv] = -1
                    answer -= 1
        elif arr[i][j] == 2:
            for di, dj in (-2, -1), (-1, -2), (-2, 1), (-1, 2), (1, 2), (2, 1), (1, -2), (2, -1):
                du, dv = i+di, j+dj
                if oob(du, dv) or arr[du][dv] != 0:
                    continue

                answer -=1
                arr[du][dv] = -1

print(answer)