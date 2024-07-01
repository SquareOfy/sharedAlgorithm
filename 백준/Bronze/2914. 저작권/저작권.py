from math import ceil
import sys

input = sys.stdin.readline

a, i = map(int, input().split())

i-=1


print(ceil(a*i+1))