n = int(input())

lst = [float(input()) for _ in range(n)]

answer = 0
number = 1.0

for i in lst:
    number *= i
    if answer < number:
        answer = number
    if number < 1:
        number = 1
print(f'{answer:.3f}')




