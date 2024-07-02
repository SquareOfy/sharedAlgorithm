import sys

input = sys.stdin.readline

T = int(input())

for i in range(T):
    arr = list(input().split())

    num = float(arr[0])

    for j in range(1,len(arr)):
        oper = arr[j]
        if(oper=='@'):
            num*=3
        elif(oper=='%'):
            num+=5
        else:
            num-=7
    print(format(num,'0.2f'))