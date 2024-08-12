def check_color(r, c, size):
    if size==1:
        return arr[r][c]
    color = arr[r][c]
    for i in range(size):
        for j in range(size):
            if arr[r+i][c+j] != color:
                return -1
    return color


def make_color_paper(r, c, size):
    color = check_color(r, c, size)
    if color != -1:
        answer[color] += 1
        return
    size //= 2
    for i in range(2):
        for j in range(2):
            make_color_paper(r + i*size, c + j*size, size)


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
answer = [0] * 2
make_color_paper(0, 0, n)
print(*answer, sep="\n")
