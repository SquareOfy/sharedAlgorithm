arr = [list(input()) for i in range(8)]
score = {'K':0, 'P':1, 'N':3, 'B':3, 'R':5, 'Q':9}
answer = 0
for i in range(8):
    for j in range(8):
        if arr[i][j] =='.':
            continue
        if ord(arr[i][j])>=97:
            answer -= score[arr[i][j].upper()]
        else:
            answer += score[arr[i][j]]
print(answer)