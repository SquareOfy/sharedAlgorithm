n, R = map(int, input().split())
N = 2**n

arr= [list(map(int, input().split())) for _ in range(N)]


def operate(l, order, arr):
    tmp = [[0]*N for _ in range(N)]

    if order == 1:
        for i in range(0, N, l):
            for j in range(0, N, l):
                for k in range(l):
                    tmp[i+k][j:j+l] = arr[i+l-1-k][j:j+l]

    elif order == 2:
        for i in range(0, N, l):
            for j in range(0, N, l):
                for k in range(l):
                    for w in range(l):
                        tmp[i+k][j+w] = arr[i+k][j+l-w-1]

    elif order == 3:
        for i in range(0, N, l):
            for j in range(0, N, l):
                rotate_tmp = [[0]*l for _ in range(l)]
                for k in range(l):
                    rotate_tmp[k] = arr[i+k][j:j+l]
                rotate_tmp = list(map(list, zip(*rotate_tmp[::-1])))
                for k in range(l):
                    tmp[i+k][j:j+l] = rotate_tmp[k][:]


    elif order == 4:
        for i in range(0, N, l):
            for j in range(0, N, l):
                rotate_tmp = [[0]*l for _ in range(l)]
                for k in range(l):
                    rotate_tmp[k] = arr[i+k][j:j+l]
                rotate_tmp = list(map(list, zip(*rotate_tmp[::])))[::-1]
                for k in range(l):
                    tmp[i+k][j:j+l] = rotate_tmp[k][:]
    elif order == 5:
        for i in range(N):
            for j in range(N):
                tmp[i][j] = arr[N-1-i][j]
        tmp = operate(l, 1, tmp)
    elif order == 6:
        for i in range(N):
            tmp[i] = arr[i][::-1]
        tmp = operate(l, 2, tmp)

    elif order == 7:
        tmp = list(map(list, zip(*arr[::-1])))
        tmp = operate(l, 4, tmp)
    else:
        tmp = list(map(list, zip(*arr)))[::-1]
        tmp = operate(l, 3, tmp)
    return tmp



for r in range(R):
    order, l=  map(int, input().split())
    arr = operate(2**l, order, arr)


for i in range(N):
    print(*arr[i])