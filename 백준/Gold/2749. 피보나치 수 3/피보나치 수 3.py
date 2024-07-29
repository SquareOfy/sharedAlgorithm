import sys
sys.setrecursionlimit(10**5)

n = int(input())
m = [[1, 1], [1, 0]]
size = 2
mod = 1000000


def multiply_matrix(matrix1, matrix2):
    result = [[0] * 2 for _ in range(2)]

    for i in range(size):
        for j in range(size):
            for k in range(size):
                result[i][j] += (matrix1[i][k] * matrix2[k][j])%mod
            result[i][j] %= mod

    return result


def power(p, matrix):
    if p == 1:
        return matrix
    half = power(p // 2, matrix)
    multiply = multiply_matrix(half, half)
    if p % 2 == 0:
        return multiply
    else:
        return multiply_matrix(multiply, matrix)


result = power(n, m)
print(result[0][1]%mod)
