t = int(input())
direction = (-1, 0), (0, -1), (1, 0), (0, 1)
def update_min_max():
    global min_r,min_c,max_r,max_c
    min_r = min(min_r, r)
    min_c = min(min_c, c)
    max_r = max(max_r, r)
    max_c = max(max_c, c)
for tc in range(t):
    order = input()

    # 직사각형 넓이 구하기 위한 x, y 좌표
    # 여기서 초기값지정할 때  0,0고려 안 했었음.. 해야함..
    min_r = 0
    min_c = 0
    max_r = 0
    max_c = 0

    # 방향 기억을 위한 변수(기본 위쪽)
    dir = 0
    r = 0
    c = 0
    for i in order:
        if i == 'F':  # 현재 보고 있는 방향대로 앞으로 +1
            r+= direction[dir][0]
            c+= direction[dir][1]
            update_min_max()
        elif i == 'B':  # 현재 보고 있는 방향 반대로 한칸 가기
            r -= direction[dir][0]
            c -= direction[dir][1]
            update_min_max()
        elif i == 'L':  # 왼쪽으로 회전
            dir = (dir+1)%4
        else:  # 오른쪽으로 회전
            dir = (dir+3)%4
    # 움직임 다 한 후 지금까지 구한 좌표로 넓이 계산해서 출력

    w = max_c-min_c
    h = max_r-min_r
    print(w*h)