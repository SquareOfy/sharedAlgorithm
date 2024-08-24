s = input()
t = input()
#s가 더 길게 세팅
if len(s)<len(t):
    s, t= t, s
idx_lst = []
word = list(s)
for i in range(len(t)):
    if t[i] in word:
        word[word.index(t[i])] = -1
b = word.count(-1)
print(len(t)-b + len(s)-b)