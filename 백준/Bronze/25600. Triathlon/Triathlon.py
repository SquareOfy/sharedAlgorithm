n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
mm = 0
for i in range(n):
    a, d, g = arr[i]
    s = a*(d+g)
    if a==(d+g):
        s *= 2
    mm = max(s, mm)
print(mm)