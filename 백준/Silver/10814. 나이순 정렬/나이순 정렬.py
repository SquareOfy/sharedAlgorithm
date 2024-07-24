n = int(input())

arr = [[i]+list(input().split()) for i in range(n)]

arr.sort(key = lambda x : (int(x[1]), x[0]))

for i in arr:
    print(*i[1:])