word = input()

cnt_lst = [0]*26
a = ord('A')
l = len(word)
for s in word:
    cnt_lst[ord(s)-a] += 1

odd_cnt = 0
is_possible = True
for i in range(25):
    if cnt_lst[i] % 2 != 0:
        odd_cnt += 1
    if (l %2 ==0 and odd_cnt >=1) or ( l %2 !=0 and odd_cnt >=2):
        is_possible = False
        break

result = [0]*l


if is_possible:
    idx = 0
    for i in range(26):
        while cnt_lst[i] >= 2:
            if cnt_lst[i] > 1:
                result[idx] = chr(i+a)
                result[l-1 - idx] = chr(i+a)
                idx += 1
                cnt_lst[i] -= 2

        if cnt_lst[i] == 1:
            result[l // 2] = chr(i + a)
            cnt_lst[i] -= 1

    print(''.join(result))
else:
    print("I'm Sorry Hansoo")