import sys

input = sys.stdin.readline

n = int(input())

paper = [[0]*100 for _ in range(100)]


result = 0

for _ in range(n):
    x, y = map(int, input().split())
    # print(f"x: {x} / y: {y}")
    for i in range(x, x+10):
        for j in range(y, y+10):
            if paper[i][j] == 0:
                paper[i][j] = 1
                result += 1

print(result)