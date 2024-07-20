plane = [[0]*101 for _ in range(101)]
answer = 0
for i in range(4):
    x1, y1, x2, y2 = map(int, input().split())

    for r in range(x1, x2):
        for c in range(y1, y2):
            if plane[r][c] == 0:
                plane[r][c] = 1
                answer += 1

print(answer)