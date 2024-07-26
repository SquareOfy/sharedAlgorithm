n = int(input())

drawings = [[list(input()) for _ in range(5)] for _ in range(n)]

gap_min = 36
result = [0,0]
for i in range(n-1):
    for j in range(i+1, n):
        cnt = 0
        for r in range(0, 5):
            for c in range(0, 7):
                if drawings[i][r][c] != drawings[j][r][c]:
                    cnt += 1

        if gap_min > cnt:
            gap_min = cnt
            result = [i+1, j+1]
print(*result)