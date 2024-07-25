lst = list(map(int, input().split()))

up = 0
down = 0
for i in range(len(lst)-1):
    if lst[i] < lst[i+1]:
        up += 1
    else:
        down += 1

if up == 7:
    print('ascending')
elif down ==7:
    print('descending')
else:
    print('mixed')