import sys

input = sys.stdin.readline

k, n, m = map(int, input().split())

result = k*n - m
if(result<0): result =0

print(result)