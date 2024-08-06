n = int(input())
chang  = 100
sang = 100
for i in range(n):
    c, s = map(int, input().split())
    if c==s:
        continue
    elif c<s:
        chang -= s
    else:
        sang -= c

print(chang)
print(sang)