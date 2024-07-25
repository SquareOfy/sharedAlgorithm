s = input()

zero_cnt = 0
one_cnt = 0

for i in range(len(s)-1):
    if s[i] == '0' and s[i+1] == '1':
        zero_cnt += 1
    elif s[i] == '1' and s[i+1] == '0':
        one_cnt += 1

if s[-1]=='0':
    zero_cnt+=1
else:
    one_cnt+=1

print(min(zero_cnt, one_cnt))