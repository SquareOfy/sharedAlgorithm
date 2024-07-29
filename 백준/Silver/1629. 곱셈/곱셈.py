a, b, c = map(int, input().split())

def multiply(i, n):
    if n == 1:
        return i%c
    half = multiply(i, n//2)
    if n%2 ==0:
        return (half*half)%c
    else:
        return (half*half*i)%c

print(multiply(a, b))