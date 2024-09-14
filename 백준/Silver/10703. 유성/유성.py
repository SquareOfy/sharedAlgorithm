"""
5 6
.XXXX.
......
...#..
#..###
######

6 3
.X.
...
.##
..#
#.#
###

"""
n, m = map(int, input().split())

arr = [list(input()) for _ in range(n)]

down = n
#내릴 수 있는 min 찾기
for c in range(m):
    cnt= 0
    for r in range(n-2, -1, -1):
        if arr[r][c]=='#':
            cnt = 0
        elif arr[r][c] == '.':
            cnt+=1
        elif arr[r][c]=='X':
            down = min(down, cnt)
            continue
for c in range(m):
    for r in range(n-2, -1, -1):
        if arr[r][c]=='X':
            arr[r][c] = '.'
            arr[r+down][c] = 'X'

for i in range(n):
    print(''.join(arr[i]))