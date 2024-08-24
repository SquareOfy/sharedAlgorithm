s = set(range(1, 31))
for i in range(28):

    n = int(input())

    s.remove(n)

lst = list(s)
lst.sort()
print(lst[0])
print(lst[1])