n = int(input())
for i in range(n):
    cnt = 1
    ans = input()
    score = 0
    for j in range(len(ans)):
        if ans[j]=='O':
            score+= cnt
            cnt+=1
        else:
            cnt=1
    print(score)