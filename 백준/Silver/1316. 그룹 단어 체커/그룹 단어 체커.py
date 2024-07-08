import sys

input = sys.stdin.readline

n = int(input())

count = 0

for _ in range(n):
    word = input().rstrip()

    s = {}
    length = len(word)
    before = word[0]
    s[word[0]] = 1
    flag = True
    for i in range(1,length):
        if(before==word[i]): continue
        if(s.get(word[i])!=None):
            flag = False
            break
    
        before = word[i]
        s[word[i]] = 1
    if(flag):
        count+=1

print(count)