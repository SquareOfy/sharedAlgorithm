t = int(input())


def find_start():
    for i in range(h):
        for j in range(w):
            if arr[i][j] in ('<', '>', '^', 'v'):
                return i, j


for tc in range(1, t + 1):
    h, w = map(int, input().split())
    arr = [list(input()) for _ in range(h)]

    n = int(input())
    lst = list(input())

    r, c = find_start()
    dir_dict = {'<':(0,-1), '>' : (0,1), '^':(-1,0), 'v':(1,0)}
    for o in lst:
        if o == 'S': #포탄 발사
            d = dir_dict[arr[r][c]]
            du = r+d[0]
            dv = c+d[1]
            while 0<=du<h and 0<=dv<w and (arr[du][dv] in ('.', '-', '*')):
                if arr[du][dv] == '*':
                    arr[du][dv] = '.'
                    break
                du += d[0]
                dv += d[1]
        elif o =='R': #오른쪽으로 방향 바꾸기 AND 오른쪽 평지면 이동
            if c+1 < w and arr[r][c+1] == '.':
                arr[r][c+1] = '>'
                arr[r][c] = '.'
                c+= 1
            else:
                arr[r][c] = '>'
        elif o =='L': #왼쪽
            if c-1 >= 0 and arr[r][c-1] == '.':
                arr[r][c-1] = '<'
                arr[r][c] = '.'
                c-= 1
            else:
                arr[r][c] = '<'
        elif o == 'U':  # 위쪽
            if r-1 >=0 and arr[r-1][c] == '.':
                arr[r-1][c] = '^'
                arr[r][c] = '.'
                r-= 1
            else:
                arr[r][c] = '^'
        elif o == 'D':  # 아래쪽
            if r+1 < h and arr[r+1][c] == '.':
                arr[r+1][c] = 'v'
                arr[r][c] = '.'
                r+= 1
            else:
                arr[r][c] = 'v'

    print(f"#{tc}", end=" ")
    for i in range(h):
        print(*arr[i], sep="")
