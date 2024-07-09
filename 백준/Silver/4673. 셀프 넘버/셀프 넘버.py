arr = list([0]*10001)

for i in range(1, 10001):
    num = i
    for s in str(i):
        num += int(s)
    if(num<=10000):
        arr[num] = 1


for i in range(1, 10001):
    if(arr[i]==0):
        print(i)