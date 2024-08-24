word = input()

for i in range(0, len(word), 10):
    print(word[i:min(i + 10, len(word))])