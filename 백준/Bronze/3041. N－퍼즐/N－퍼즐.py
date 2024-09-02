def get_distance(a, b):
    return abs(a[0]-b[0])+abs(a[1]-b[1])
a = ord('A')
correct = {0: (0, 0), 1: (0, 1), 2: (0, 2), 3: (0, 3), 4: (1, 0), 5: (1, 1), 6: (1, 2), 7: (1, 3), 8: (2, 0), 9: (2, 1), 10: (2, 2), 11: (2, 3), 12: (3, 0), 13: (3, 1), 14: (3, 2), -19: (3, 3)}

arr = [list(input()) for i in range(4)]
answer = 0
for i in range(4):
    for j in range(4):
        if arr[i][j] == '.':
            continue
        t = ord(arr[i][j])-a

        answer += get_distance((i, j), correct[t])
print(answer)
