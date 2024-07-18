n = int(input())


for i in range(1,2*n):
    for j in range(abs(i-2*n//2)):
        print(" ", end="")
    for k in range(2*(n-abs(i-2*n//2))-1):
        print('*', end="")
    print()