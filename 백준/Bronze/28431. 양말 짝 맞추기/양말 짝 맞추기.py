
socks = [0]*10
for i in range(5):
    socks[int(input())]+=1

for i in range(10):
    if socks[i] % 2 ==1:
        print(i)