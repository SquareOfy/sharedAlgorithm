word = input()

if word[:len(word)//2] == word[-1:-(len(word)//2+1):-1]:
    print(1)
else:
    print(0)