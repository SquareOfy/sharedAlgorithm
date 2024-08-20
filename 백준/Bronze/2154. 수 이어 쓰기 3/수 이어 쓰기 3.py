n = int(input())
num = ''
str_n = str(n)

for i in range(1,n+1):
    tmp = str(i)
    num+=tmp
for i in range(0, len(num)-len(str_n)+1):
    if num[i:i+len(str_n)] == str_n:
        print(i+1)
        break