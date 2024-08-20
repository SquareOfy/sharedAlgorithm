n = int(input())
word = list(input())

for i in range(n//2):
    if word[i]=='?':
        if word[n-1-i]!='?' and n-1-i != i:
            word[i] = word[n-i-1]
        else:
            word[i]='a'
            word[n-i-1]='a'
    elif word[n-i-1] == '?':
        word[n-1-i] = word[i]
if n==1:
    word[0] = 'a'
if n>2 and word[n//2] == '?':
    word[n//2] = 'a'
print(*word, sep="")