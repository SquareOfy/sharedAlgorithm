n = int(input())
lst = []

for i in range(2700000):
    if '666' in str(i) and not i in lst:
        lst.append(i)

lst.sort()
print(lst[n-1])