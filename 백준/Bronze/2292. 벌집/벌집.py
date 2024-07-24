n = int(input())
k = 1
lst = [1]
while 1:
    if lst[-1] >= n:
        break
    lst.append(lst[-1]+6*k)
    k+= 1
print(k)