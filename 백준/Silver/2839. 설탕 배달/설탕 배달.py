import sys
n = int(sys.stdin.readline())

if n%5 == 0:
    num = n//5
elif (n%5) != 0:
    if (n%5) == 3:
        num = (n//5) + (n%5)//3
    elif n >5 and (n%5 ==1 or n%5 == 4):
        num = (n//5) -1 + (n%5+5)//3
    elif n >10 and n%5 == 2:
        num = (n//5) -2 + (n%5 +10)//3
    else:
        num = -1

print(num)
