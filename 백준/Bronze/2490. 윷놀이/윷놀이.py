for i in range(3):
    lst = list(map(int, input().split()))
    r = sum(lst)
    if r==3:
        print('A')
    elif r==2:
        print('B')
    elif r==1:
        print('C')
    elif r==0:
        print('D')
    else:
        print('E')