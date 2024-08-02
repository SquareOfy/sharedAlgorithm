import sys
input = sys.stdin.readline
n, m = map(int, input().rstrip().split())
lst = [0]
lst.extend(list(map(int, input().rstrip().split())))
for i in range(1, n+1):
    lst[i] += lst[i-1]
for k in range(m):
    i, j = map(int, input().rstrip().split())
    print(lst[j] - lst[i-1])