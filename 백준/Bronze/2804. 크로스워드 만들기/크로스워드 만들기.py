a, b = input().split()
m, n = len(a), len(b)
arr = [['.']*m for _ in range(n)]
row = -1
col = -1
for i in range(n):
    ch = a[i]
    if ch in b:
        row = b.index(ch)
        col = i
        break
arr[row][:] = list(a)

for j in range(n):
    arr[j][col] = b[j]

for i in range(n):
    print(*arr[i], sep="")
