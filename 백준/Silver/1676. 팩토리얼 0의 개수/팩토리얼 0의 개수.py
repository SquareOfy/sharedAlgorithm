n = int(input())
two = 0
five = 0
for i in range(1, n+1):
    tmp1 = i
    tmp2 = i
    while tmp1 % 2 == 0:
        two+= 1
        tmp1 //= 2
    while tmp2 % 5 == 0:
        five+= 1
        tmp2 //= 5

print(min(two, five))
