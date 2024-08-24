answer = -1
mm = 0
for i in range(5):
    lst = list(map(int, input().split()))
    s = sum(lst)
    if mm < s:
        answer = i+1
        mm = s
print(answer, mm)