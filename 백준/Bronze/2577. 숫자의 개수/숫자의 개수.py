a = int(input())
b = int(input())
c = int(input())

result=str(a*b*c)

for i in range(0,10):
    if str(i) in result:
        print(result.count(str(i)))
    else:
        print(0)
