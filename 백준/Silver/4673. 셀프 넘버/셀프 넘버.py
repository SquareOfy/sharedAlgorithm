self_numbers = [0] * 10001

for i in range(1,10001):
    str_num = str(i)
    num = i
    flag = True
    for s in str_num:
        num += int(s)
        if(num > 10000):
            flag = False
            break

    if(flag and num != i):
        self_numbers[num] = 1


for i in range(1, 10001):
    if(self_numbers[i]!=1):
        print(i)