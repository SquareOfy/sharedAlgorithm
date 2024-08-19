word = input()

vowel = ['a','e','i','o','u']
cnt = 0
for v in vowel:
    if v in word:
        cnt += word.count(v)
print(cnt)