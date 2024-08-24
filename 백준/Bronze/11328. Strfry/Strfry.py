n = int(input())
for i in range(n):
    a, b = input().split()
    result = 'Possible'
    for i in a:
        if i not in b:
            result = 'Impossible'
            break
        if a.count(i) != b.count(i):
            result = 'Impossible'
            break
    print(result)