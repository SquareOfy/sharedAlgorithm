n = int(input())

finger = 1
plus = 1
num = 1

while num < n :
    finger += plus*4
    plus*= -1
    num += 4

if num > n:
    finger += plus*(num-n)
print(finger)



