visited = [[0]*6 for i in range(6)]
flag = False
cnt = 0
answer = "Invalid"
night_d = (-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2)
before = (-1, -1)
for i in range(36):
    move = input()
    if flag:
        continue
    r = ord(move[0])-ord('A')
    c = int(move[1]) -1
    this_flag = False

    if i!=0:
        for d in night_d:
            du = before[0] + d[0]
            dv = before[1] + d[1]

            if du==r and dv == c:

                this_flag = True
                break
    else:
        start = (r, c)
    if not this_flag and i!=0:
        flag = True
        continue
    if visited[r][c]:
        flag = True
        continue
    visited[r][c] = 1
    cnt+=1
    before = (r,c)

        # print(move)
    if cnt == 36:
        #현재 위치에서 L자 모양인 곳 중에 시작 지점이 있는지 체크
        for d in night_d:
            du = r+d[0]
            dv = c+d[1]
            if du==start[0] and dv==start[1]:
                # print(du, dv)
                answer= "Valid"
                break

print(answer)
