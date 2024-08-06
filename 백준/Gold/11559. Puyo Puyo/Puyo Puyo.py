from collections import deque
arr = [list(input()) for i in range(12)]
direction = ((-1, 0), (0, -1), (1,0), (0, 1))

def bfs(r, c):
    global tmp
    q = deque([[r,c]])
    visited[r][c] = 1

    while q:
        now = q.popleft()
        for d in direction:
            du = now[0]+d[0]
            dv = now[1]+d[1]
            if du <0 or du>=12 or dv<0 or dv>=6:
                continue
            if arr[du][dv] == arr[now[0]][now[1]] and not visited[du][dv]:
                q.append([du,dv])
                tmp+=1
                visited[du][dv] = 1
def puyo_bfs(r,c, p):
    q = deque([[r,c,p]])
    arr[r][c] = '.'

    while q:
        now = q.popleft()
        for d in direction:
            du = now[0]+d[0]
            dv = now[1]+d[1]

            if du not in range(12) or dv not in range(6):
                continue

            if arr[du][dv] == now[2] and visited[du][dv]:
                q.append([du,dv, now[2]])
                arr[du][dv] = '.'
puyo = 0
while 1:
    #현재 4개 이상 연쇄
    cnt = 0
    visited = [[0]*6 for i in range(12)]
    for r in range(12):
        for c in range(6):
            if arr[r][c] != '.' and not visited[r][c]:
                tmp=1
                bfs(r,c)
                if tmp>=4:
                    cnt+=1
                    puyo_bfs(r,c, arr[r][c])

    #연쇄 없으면 종료
    if cnt == 0:
        break
    puyo += 1 #연쇄 추가
    # print()
    # for i in range(12):
    #     print(arr[i])

    #중력 작용
    for r in range(10, -1, -1):
        for c in range(6):
            idx = r
            flag = False
            if arr[r][c] !='.' :
                while idx+1 <12 and arr[idx+1][c] == '.':
                    idx+=1
                    flag = True
                if flag:
                    arr[idx][c] = arr[r][c]
                    arr[r][c] = '.'
    # print()
    # for i in range(12):
    #     print(arr[i])

print(puyo)

