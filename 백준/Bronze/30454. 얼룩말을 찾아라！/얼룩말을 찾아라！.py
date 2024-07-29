n, l = map(int, input().split())
lst = [ input() for _ in range(n)]
max_black = 0
cnt = 0
for i in lst:
    tmp = 0
    if '01' in i:
        tmp += i.count('01')
    if i[0] == '1':
        tmp+=1

    if max_black < tmp:
        max_black = tmp
        cnt = 1
    elif max_black == tmp:
        cnt+=1

print(max_black, cnt)