n = int(input())
m = int(input())

arr = [[0]*n for _ in range(n)]

r = n//2
c = n//2

turn = 1
cnt = 1
arr[r][c] = 1
result = [r+1,c+1]
idx = 2
def write_num():
    global arr, result, idx

    arr[r][c] = idx

    if idx == m:
        result = [r+1, c+1]
    idx+=1



while idx < n*n :
    if cnt % 4 == 1 : #up
        for i in range(turn):
            if idx > n*n:
                break
            r -= 1
            write_num()
        cnt+=1

    elif cnt % 4 == 2 : #right
        for i in range(turn):
            c += 1
            write_num()
        cnt += 1
        turn += 1

    elif cnt % 4 == 3 : #down
        for i in range(turn):
            r += 1
            write_num()
        cnt += 1

    elif cnt % 4 == 0: #left
        for i in range(turn):
            c -= 1
            write_num()
        cnt += 1
        turn += 1


for i in arr:
    print(*i)
print(*result)