def climb_ladder(st, down):
    d = -1 if down else 1
    r = down
    c = st

    while r != blank_r:
        # print(c)
        #양 옆 보기
        left = c-1
        right = c +1
        # print(r)
        # print(right)
        if left>=0 and arr[r][left] == 1:
            c-= 2
        elif right< W and arr[r][right] == 1:
            c+=2
        elif (left>=0 and arr[r][left]==2) or (right<W and arr[r][right]==2):
            return c
        r += d
    return c



K = int(input())
N = int(input())
result_order = list(input())
arr = []
blank_r = -1
flag = True
for n in range(N):
    w = input()
    w = w.replace('*', '0')
    w = w.replace('-', '1')
    w = w.replace('?', '2')
    if '2' in w:
        blank_r = n
    arr.append(list(map(int, list('1'+'1'.join(w)+'1'))))
a = ord('A')
W = 2*K-1
for k in range(K):
    alpha = result_order[k]
    #윗줄 시작 index
    top = 2*(ord(alpha)-(a))
    #아랫줄 시작 index
    bottom = 2*k

    #top 사다리 타고 내려왔을 때의 열
    top_c = climb_ladder(top, 0)
    #bottom 사다리 타고 내려왔을 때의 열
    bottom_c = climb_ladder(bottom, N-1)

    #둘이 같으면 양 쪽 0 (이미 1이 들어와 있으면 불가)
    if top_c ==  bottom_c:
        if (top_c -1 >=0 and arr[blank_r][top_c-1] ==1) or (top_c+1 < W and arr[blank_r][top_c+1]==1):
            flag = False
            break
        if top_c-1 >=0:
            arr[blank_r][top_c - 1] = 0
        if top_c+1 < W:
            arr[blank_r][top_c + 1] = 0
    #bottom열이 더 작고 1차이면 bottom 오른쪽에 1
    elif top_c - bottom_c == 2:
        if bottom_c+1 < W:
            if arr[blank_r][bottom_c+1] == 0:
                flag = False
                break
            arr[blank_r][bottom_c + 1] = 1
        if bottom_c-1 >=0:
            if arr[blank_r][bottom_c-1] == 1:
                flag = False
                break
            arr[blank_r][bottom_c - 1] = 0

    #top열이 더 작고 1차이면 top 오른쪽에 1
    elif bottom_c - top_c == 2:
        if top_c+1 < W:
            if arr[blank_r][top_c+1] == 0:
                flag = False
                break
            arr[blank_r][top_c + 1] = 1
        if top_c-1 >=0:
            if arr[blank_r][top_c-1] == 1:
                flag = False
                break
            arr[blank_r][top_c - 1] = 0
    elif abs(bottom_c-top_c)>2:
        flag=False
        break


if flag:
    answer = ''
    for i in range(1, 2*K-1, 2):
        answer += str(arr[blank_r][i]).replace('0', '*').replace('1', '-')
    print(answer)
else:
    print('x'*(K-1))