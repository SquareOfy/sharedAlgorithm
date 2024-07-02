import sys
from math import gcd

input = sys.stdin.readline

t = int(input())

for i in range(t):
    a, b = map(int, input().split())
    d = gcd(a, b)
    print(int(a*b/d))