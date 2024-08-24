lst = ['a', 'e', 'i', 'o', 'u']
while 1:
    sentence = input().lower()
    if sentence == '#':
        break
    cnt = 0
    for i in lst:
        cnt+= sentence.count(i)
    print(cnt)