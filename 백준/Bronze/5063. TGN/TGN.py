import sys

input = sys.stdin.readline

t = int(input())

for i in range(t):
    r, e, c = map(int, input().split())

    output = (e-c)-r

    if(output>0):
        print('advertise')
    elif(output==0):
        print('does not matter')
    else:
        print('do not advertise')