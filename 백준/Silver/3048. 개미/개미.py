n, m = map(int, input().split())
o1 = input()
o2 = input()
t = int(input())

lst = list(o1[::-1])+list(o2)
for j in range(t):
    flag = False
    for i in range(1, n+m):
        if flag:
            flag = False
            continue
        if (lst[i-1] in o1 and lst[i] in o1) or (lst[i-1] in o2 and lst[i] in o2):
            continue
        if lst[i-1] in o2 and lst[i] in o1:
            continue
        lst[i], lst[i-1] = lst[i-1], lst[i]
        flag = True
print(''.join(lst))

