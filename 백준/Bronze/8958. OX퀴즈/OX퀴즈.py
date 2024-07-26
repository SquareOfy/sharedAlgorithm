n = int(input())

for i in range(n):
    quiz = input()
    cnt = 0
    score = 0
    for j in quiz:
        if j == 'O':
            cnt += 1
            score+= cnt
        else:
            cnt = 0
        
    print(score)