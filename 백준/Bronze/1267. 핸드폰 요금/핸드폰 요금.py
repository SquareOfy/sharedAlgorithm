n = int(input())
lst = list(map(int, input().split()))
y = 0
m = 0
for i in range(n):
    y+= (lst[i] // 30 + 1) * 10
    m+= (lst[i]//60+1)*15
if y<m:
    print(f"Y {y}")
elif y>m:
    print(f"M {m}")
else:
    print(f"Y M {y}")