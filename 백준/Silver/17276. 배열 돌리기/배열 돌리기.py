def rotate(a):
    """
    i>0이면 시계방향회전
    i<0이면 반시계방향 회전

    바깥에서 안쪽으로 가면서 시계/반시계방향으로 n//2~0칸씩 내려주기
    """
    ll = n//2
    if a<0:
        dir = (0, 1), (1, 0), (0, -1), (-1, 0)
    else:
        dir = (1, 0), (0, 1), (-1, 0), (0, -1)

    for w in range(abs(a)//45):
        for i in range(ll):
            down = ll-i
            # print("down : ", down)
            r, c= i, i #시작지점
            tmp = arr[r][c]
            #우 / 하 / 좌 상 순으로
            for di, dj in dir:
                while 1:
                    du = r+di*down
                    dv = c+dj*down
                    if du<i or dv<i or du>=n-i or dv>=n-i or (du==i and dv==i):
                        break
                    arr[r][c] = arr[du][dv]
                    r, c = du, dv
            arr[r][c] = tmp

t = int(input())

for tc in range(t):
    n, l = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]


    rotate(l)
    for k in range(n):
        print(*arr[k])