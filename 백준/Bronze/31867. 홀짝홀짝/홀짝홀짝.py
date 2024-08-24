n = int(input())
k = input()
odd = 0
for i in k:
    if int(i) % 2 == 1:
        odd += 1

if odd < n-odd:
    print(0)
elif odd > n-odd:
    print(1)
else:
    print(-1)