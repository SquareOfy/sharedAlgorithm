cnt = 0
alph = 'MOBIS'
word = input()
for i in alph:
    if i in word:
        cnt+=1
if cnt==5:
    print('YES')
else:
    print('NO')