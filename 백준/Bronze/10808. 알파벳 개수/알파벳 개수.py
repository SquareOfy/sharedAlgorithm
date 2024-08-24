s = input()
lst = [0]*26
for i in s:
    lst[ord(i)-ord('a')] +=1
print(*lst)