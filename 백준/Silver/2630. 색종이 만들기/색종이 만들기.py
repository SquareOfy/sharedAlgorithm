n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]
blue = 0
white = 0


def check_same_color(l, r, c):
    color = arr[r][c]
    for i in range(r, r + l):
        for j in range(c, c + l):
            if arr[i][j] != color:
                return -1
    return color


def cut_paper(l, r, c):
    global blue
    global white
    if l == 1:
        if arr[r][c] == 0:
            white += 1
        else:
            blue += 1
        return
    result = check_same_color(l, r, c)

    if result == 0:
        white += 1
        return
    if result == 1:
        blue += 1
        return
    next = l // 2
    cut_paper(next, r, c)
    cut_paper(next, r + next, c)
    cut_paper(next, r, c + next)
    cut_paper(next, r + next, c + next)


cut_paper(n, 0, 0)
print(white)
print(blue)
