lst = [0]
for i in input():
    if i == 'Y':
        lst.append(1)
    else:
        lst.append(0)
cnt = 0
while 1 in lst:
    i = lst.index(1)
    cnt += 1
    for j in range(i, len(lst), i):
        lst[j] = (lst[j]+1)%2

print(cnt)