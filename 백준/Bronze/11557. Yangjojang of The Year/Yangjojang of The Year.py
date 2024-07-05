import sys

input = sys.stdin.readline

t = int(input())

for i in range(t):
    n = int(input())
    result =''
    m = 0
    for j in range(n):
        school, alchol = input().split()
        alchol = int(alchol)
        if(alchol>m):
            m = alchol
            result = school
    print(result)