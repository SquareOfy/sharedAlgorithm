num1 = input()
num2 = input()
lst = []
for i in range(8):
    lst.append(num1[i])
    lst.append(num2[i])

while len(lst) !=2:
    l = len(lst)
    tmp = []
    for j in range(0, l-1):
        num = (int(lst[j])+int(lst[j+1]))%10
        tmp.append(str(num))
    lst = tmp

print(*lst, sep="")
