import sys

input = sys.stdin.readline

plates = list(input().rstrip())

h = 10
for i in range(1, len(plates)):
    if(plates[i-1]==plates[i]):
        h+=5
    else: h+=10
print(h)