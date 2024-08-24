d = 0
p = 0
n = int(input())
for i in range(n):
    result = input()
    if abs(d-p)>=2:
        continue
    if result == 'D':
        d+=1
    else:
        p+=1
print(f'{d}:{p}')