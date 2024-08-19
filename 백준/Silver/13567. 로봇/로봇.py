m, n = map(int, input().split())
order = [list(input().split()) for _ in range(n)]
#범위 m까지 ok
d_idx = 3
directions = (1, 0), (0, -1), (-1, 0), (0, 1)
r, c = 0, 0
flag = 1
for i in range(n):
    d = int(order[i][1])
    #회전
    if order[i][0] == 'TURN':
        if d==0:#왼쪽 회전
            d_idx+=1
            d_idx%=4
        else:
            d_idx+=3
            d_idx%=4
    #move
    else:
        du = r+directions[d_idx][0]*d
        dv = c+directions[d_idx][1]*d
        if du<0 or dv<0 or du>m or dv>m:
            flag = 0
            break
        r = du
        c = dv
if flag:
    print(c, r)
else:
    print(-1)