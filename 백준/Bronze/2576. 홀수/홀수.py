ma = 100
ms = 0
for i in range(7):
    n = int(input())
    if n%2==0:
        continue
    ma = min(ma, n)
    ms += n
print(-1 if ma==100 else f"{ms}\n{ma}")