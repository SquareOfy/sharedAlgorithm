n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]
answer = [0]*3

def check_paper(l, r, c):
    num = arr[r][c]

    for i in range(l):
        for j in range(l):
            if arr[r+i][c+j] != num:
                return False
    return True

def cut_paper(l, r, c):
    if check_paper(l, r, c) or l==1:
        answer[arr[r][c]+1] += 1
        return

    size = l//3

    for i in range(3):
        for j in range(3):
            cut_paper(size, r+i*size, c+j*size)

cut_paper(n, 0, 0)
print(*answer, sep='\n')