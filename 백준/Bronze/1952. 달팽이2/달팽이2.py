m, n = map(int, input().split())
arr = [[0] * n for _ in range(m)]
arr[0][0] = 1
dir = (0, 1), (1, 0), (0, -1), (-1, 0)
r, c = 0, 0
idx = 0
d = dir[idx]
answer = 0
cnt = 0
while 1:
    arr[r][c] = 1
    du = r + d[0]
    dv = c + d[1]
    if du < 0 or dv < 0 or du >= m or dv >= n or arr[du][dv]:
        idx += 1
        idx %= 4
        d = dir[idx]
        cnt += 1
        if cnt==4:
            answer -=3
            break
        answer+=1
        continue
    r, c = du, dv
    cnt = 0

print(answer)