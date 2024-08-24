mm = 0
now =0
for i in range(10):
    minus, plus = map(int, input().split())
    now += plus-minus
    if now > mm:
        mm = now

print(mm)