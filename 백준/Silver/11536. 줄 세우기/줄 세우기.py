n = int(input())
lst = [input() for _ in range(n)]
sorted_lst = sorted(lst)
if lst==sorted_lst:
    print('INCREASING')
elif lst[-1::-1] == sorted_lst:
    print('DECREASING')
else:
    print('NEITHER')

