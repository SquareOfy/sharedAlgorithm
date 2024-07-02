import sys

input = sys.stdin.readline

a = int(input())
oper = input().rstrip()
b = int(input())

if(oper=='*'):
    print(a*b)
elif(oper=='+'):
    print(a+b)