def check(r, c, size):
    first = arr[r][c]
    for i in range(r, r + size):
        for j in range(c, c + size):
            if arr[i][j] != first:
                return -1
    return first


def divide(r, c, size):
    if size == 1:
        print(arr[r][c], end="")

        return
    result = check(r, c, size)
    if result != -1:
        print(result, end="")
        return
    else:
        print("(", end="")
        next = size // 2
        for i in range(2):
            for j in range(2):
                divide(r + i * next, c + j * next, next)
        print(")", end="")


n = int(input())
arr = [list(map(int, list(input()))) for _ in range(n)]
divide(0, 0, n)
