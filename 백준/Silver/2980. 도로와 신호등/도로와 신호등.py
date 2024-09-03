n, l = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]
now = 0
time = 0
for i in range(n):
    d, r, g = arr[i]
    time += d-now
    now = d

    if time < r:
        time += r-time
    else:
        if time %(r+g) < r:
            time += r - (time%(r+g))
time += l - now
print(time)