n, x = map(int, input().split())
arr = []
for i in range(n):
    s, t = map(int, input().split())
    if s+t > x:
        continue
    arr.append(s)
if len(arr)==0:
    print(-1)
else:
    arr.sort(reverse=True)
    print(arr[0])