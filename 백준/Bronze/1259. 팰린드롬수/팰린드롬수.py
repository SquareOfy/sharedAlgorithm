while 1:
    n = input()
    if n == '0':
        break
    lst = list(n)
    l = len(lst)

    if lst[:l // 2] == lst[-1:-(l//2)-1:-1]:
        print('yes')
    else:
        print('no')