from collections import deque
m,n,h = map(int, input().split())

arr = [[list(map(int, input().split())) for i in range(n)] for j in range(h)]

q = deque([])
cnt = 0 #익지 않은 토마토 개수
for i in range(h):
    for j in range(n):
        for k in range(m):
            if arr[i][j][k] == 1:
                q.append([i,j,k, 0])
            elif arr[i][j][k] == 0:
                cnt+=1
if cnt == 0:
    print(0)
else:
    answer = 0
    while q:
        now = q.popleft();
        k, r, c, rank = now
        answer = rank
        for d in (-1, 0, 0), (0, -1, 0), (0, 0, -1), (1, 0, 0), (0, 1, 0), (0, 0, 1):
            dk = k+ d[0]
            du = r+d[1]
            dv = c+d[2]
            if dk<0 or dk>=h or du<0 or du>=n or dv<0 or dv>=m:
                continue

            if arr[dk][du][dv] == 0 :
                arr[dk][du][dv] = 1
                q.append([dk, du, dv, rank+1])
                cnt -= 1

    if cnt == 0:
        print(answer)
    else:
        print(-1)