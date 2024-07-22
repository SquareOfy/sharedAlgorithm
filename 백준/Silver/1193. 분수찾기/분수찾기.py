n = int(input())

i = 1
while 1:
    if i*(i-1)//2 < n <= i*(i+1)//2:
        break
    i+= 1
start = i*(i-1)//2
num = n-start
if i%2 == 0:
    print(f"{num}/{i+1-num}")
else:
    print(f"{i+1-num}/{num}")

