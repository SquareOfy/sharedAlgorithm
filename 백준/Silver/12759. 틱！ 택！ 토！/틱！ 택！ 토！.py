turn = int(input()) -1

arr = [['-1']*3 for _ in range(3)]

def check(r, c, t):
    if r + c == 2:  # 왼쪽 대각선일때

        for i in range(3):
            if arr[2-i][i]!=t:
                break
        else:
            return True
    if r==c:
        for i in range(3):
            if arr[i][i] != t:
                break
        else:
            return True
    for i in range(3):
        if arr[i][c] != t:
            break
    else:
        return True
    for i in range(3):
        if arr[r][i] != t:
            break
    else:
        return True
    return False


for i in range(9):
    r, c = map(lambda x : int(x)-1, input().split())
    arr[r][c] = turn
    if check(r, c, turn):
        print(turn+1)
        break
    turn ^= 1
else:
    print(0)