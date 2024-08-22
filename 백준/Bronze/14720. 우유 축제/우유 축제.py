n = int(input())
lst = list(map(int, input().split()))
now = 0
cnt = 0
for i in lst:
    if i ==now:
        now += 1
        now %= 3
        cnt += 1
print(cnt)