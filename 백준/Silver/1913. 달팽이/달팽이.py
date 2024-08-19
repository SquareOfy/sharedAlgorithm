def move(d):
    global r,c, cnt, num
    for k in range(cnt):
        r += d[0]
        c += d[1]
        if r>=n or r<0 or c<0 or c>=n:
            return False
        arr[r][c] = num
        if num == t:
            answer[0] =r+1
            answer[1] = c+1
        num+=1
        if k!=cnt-1:
            if d[0] != 0 and r==0:
                return False
    if d in ((0, 1), (0, -1)):
        cnt += 1
    return True
n = int(input())
t = int(input())

answer = [-1, -1]
arr = [[0] * n for _ in range(n)]

r = n//2
c = n//2
arr[r][c] = 1
cnt = 1 #이동할 칸수
num = 2
if t ==1:
    answer = [r+1, c+1]

while 1:
    #위로 이동
    if not move((-1, 0)):
        break
    #오른쪽 이동 : 이동 후 이동하는 칸수 증가
    if not move((0, 1)):
        break
    #아래쪽 이동
    if not move((1,0)):
        break
    #왼쪽이동 : 이동 후 이동하는 칸 수 증가
    if not move((0, -1)):
        break

for i in range(n):
    print(*arr[i])
print(*answer)