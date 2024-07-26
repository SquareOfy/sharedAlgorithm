omok = [list(input()) for _ in range(10)]



def check_omok():
    for i in range(10):
        for j in range(10):
            if omok[i][j]=='X':

                for d in ((1, 0), (0, 1), (1, 1), (1, -1)):
                    du = i-d[0]
                    dv = j-d[1]
                    if 0<=du<10 and 0<=dv<10 and omok[du][dv] == 'X':
                        continue

                    cnt = 1
                    du = i + d[0]
                    dv = j + d[1]
                    while 0<=du<10 and 0<=dv<10 and omok[du][dv] =='X':
                        cnt += 1
                        du += d[0]
                        dv += d[1]
                        if cnt >= 5:
                            return True
                            break
    return False


def try_omok():
    for i in range(10):
        for j in range(10):
            # .인 칸에 X 둬보기
            if omok[i][j] == '.':
                omok[i][j] = 'X'
                if check_omok():
                    print(1)
                    return
                #되돌리고 다른 칸 두러 ㄱㄱ
                omok[i][j] = '.'

    print(0)
    return

try_omok()
