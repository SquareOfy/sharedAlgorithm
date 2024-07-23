m = int(input())
cups = [i for i in range(4)]

for i in range(m):
    x, y = map(int, input().split())
    cups[x], cups[y] = cups[y], cups[x]


print(cups.index(1))