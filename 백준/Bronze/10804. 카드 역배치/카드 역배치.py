lst = [i for i in range(21)]
for i in range(10):
    a, b = map(int, input().split())

    lst[a:b+1] = lst[b:a-1:-1]
print(*lst[1:])