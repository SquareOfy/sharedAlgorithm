DIR = (0, -1), (0, 1), (-1, 0), (1, 0)
DIR_DICT = {'right':(0, -1), 'left':(0, 1), 'up':(1, 0), 'down':(-1, 0)}
T = int(input())

def oob(i, j):
    return i<0 or j<0 or i>=N or j>=N
def merge():
    if di:
        st = 0 if di>0 else N-1
        ed = N if st==0 else -1

        for j in range(N):
            for i in range(st, ed, di):
                if arr[i][j] ==0: continue
                du, dv = i+di, j+dj
                while not oob(du, dv) and arr[du][dv]==0:
                    du+=di
                    dv+=dj
                if oob(du,dv): continue
                if arr[du][dv] == arr[i][j]:
                    arr[i][j]*=2
                    arr[du][dv] = 0


    else:
        st = 0 if dj > 0 else N - 1
        ed = N if st == 0 else -1

        for i in range(N):
            for j in range(st, ed, dj):
                if arr[i][j] == 0: continue
                du, dv = i + di, j + dj
                while not oob(du, dv) and arr[du][dv] == 0:
                    du += di
                    dv += dj
                if oob(du, dv): continue
                if arr[du][dv] == arr[i][j]:
                    arr[i][j] *= 2
                    arr[du][dv] = 0


def gravity():
    new_arr =[[0]*N for _ in range(N)]
    if di:
        st = 0 if di > 0 else N - 1
        ed = N if st == 0 else -1
        for j in range(N):
            idx = st
            for i in range(st, ed, di):
                if arr[i][j] == 0: continue
                new_arr[idx][j] = arr[i][j]
                idx += di
    else:
        st = 0 if dj > 0 else N - 1
        ed = N if st == 0 else -1
        for i in range(N):
            idx = st
            for j in range(st, ed, dj):
                if arr[i][j] == 0: continue
                new_arr[i][idx] = arr[i][j]
                idx+=dj

    return new_arr

for t in range(1, T+1):
    N, order = input().split()
    N = int(N)

    arr = [list(map(int, input().split())) for _ in range(N)]
    if N>1:
        di, dj = DIR_DICT[order]

        merge()
        # print("===============merge================")
        # for i in range(N):
        #     print(*arr[i])
        arr = gravity()

    print(f"Case #{t}:")
    for i in range(N):
        print(*arr[i])