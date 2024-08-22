#무효x > 무효
#바위 > 가위 > 보 > 바위

a, b = map(int, input().split())

win = (0, 2), (2, 5), (5, 0)

if a in (0, 2, 5):
    if (a, b) in win or b not in (0, 2, 5):
        print('>')
    elif a==b:
        print('=')
    else:
        print('<')
else:
    if b in (0, 2, 5):
        print('<')
    else:
        print('=')