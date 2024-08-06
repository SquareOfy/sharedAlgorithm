n = int(input())

for i in range(n):
    string = input()
    if string == 'P=NP':
        print('skipped')
    else:
        lst = string.split('+')
        print(int(lst[0])+int(lst[1]))