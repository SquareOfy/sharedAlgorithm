k, n, m = map(int, input().split())
snack = k*n
if snack>m:
    print(snack-m)
else:
    print(0)