n, r, c = map(int, input().split())

cnt = 0
answer = 0


def zigzag(l, i, j):
    global cnt
    global answer
    if l == 1:
        if i == r and j == c:
            answer = cnt
        cnt += 1
        return

    size = l//2
    if i<=r<i+size and j<=c<j+size:
        zigzag(size, i, j)
    elif i<=r<i+size and j+size<=c<j+size*2:
        cnt+= size*size
        zigzag(size, i, j+size)
    elif i+size<=r<i+size*2 and j<=c<j+size:
        cnt+= size*size*2
        zigzag(size, i+size, j)
    else:
        cnt+= size*size*3
        zigzag(size, i+size, j+size)


zigzag(2 ** n, 0, 0)
print(answer)
