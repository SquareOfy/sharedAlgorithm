import sys

input = sys.stdin.readline

n = int(input())
answer =0
for i in range(n):
    dic = dict()
    word = input().rstrip()
    
    before = word[0]
    dic[before] = 1
    flag = True
    for j in range(1,len(word)):
        if word[j] != word[j-1] and dic.get(word[j]) == 1:
            flag = False
            break
        before=word[j]
        dic[before] = 1
    if(flag): answer += 1

print(answer)