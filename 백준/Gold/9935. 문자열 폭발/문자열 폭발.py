string = input()
bomb = input()
l = len(bomb)
stk = []
idx = 0
for s in string:
    #idx 값 세팅
    stk.append(s)
    if idx == l-1 and bomb[idx] == s :
        for k in range(l):
            stk.pop()
        idx = 0
    elif s in bomb:
        i = bomb.index(s)

        if len(stk) > i: #스택에 bomb 앞 문자열만큼의 문자가 들어있으면
            cnt = 0
            for k in range(i): #top부터 그 앞까지 문자열 일치하는지 확인
                if stk[-i-1+k] == bomb[k]:
                    cnt += 1
            if cnt == i:
                idx = i+1
                if idx == l:
                    for k in range(l):
                        stk.pop()
                    idx = 0
            else:
                idx = 0
        else:
            idx = 0
    else:
        idx = 0

if stk:
    print(*stk, sep='')
else:
    print("FRULA")


