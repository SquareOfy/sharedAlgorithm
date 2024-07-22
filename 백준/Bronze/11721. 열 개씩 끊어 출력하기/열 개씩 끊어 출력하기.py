word = input()

n = len(word)

for i in range(n//10):
    print(word[i*10:(i+1)*10])

if n % 10 != 0:
    print(word[10*(n//10):])
