n, b = map(int, input().split())


def module(i):
    result = int(i) % 1000
    return result


arr = [list(map(module, input().split())) for _ in range(n)]


def multiply(matrix1, matrix2):
    result = [[0] * n for _ in range(n)]
    for r in range(n):
        for c in range(n):
            for k in range(n):
                result[r][c] += matrix1[r][k]*matrix2[k][c]
            result[r][c] %= 1000
    return result


def power(matrix, i):
    if i == 1:
        return matrix
    half = power(matrix, i // 2)
    result = multiply(half, half)
    if i % 2 == 0:
        return result
    else:
        return multiply(result, matrix)


result = power(arr, b)
for i in result:
    print(*i)
