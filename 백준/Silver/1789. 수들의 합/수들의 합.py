s = int(input())

n = 1

while 1:
    n_sum = n*(n+1)//2

    if s >= n_sum and s - n_sum <= n:
        break
    n+=1
print(n)