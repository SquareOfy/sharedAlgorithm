lst = list(input())

n = len(lst)
cnt = 0
isPossible = True
for i in range(n):
    if lst[i] == 'X':
        cnt += 1
    else:
        if cnt % 2 == 1:
            isPossible = False
            break
        if cnt >= 4:
            for j in range(i - cnt, i-3, 4):
                lst[j:j + 4] = ['A', 'A', 'A', 'A']
        if cnt % 4 == 2:
            lst[i - 2:i] = ['B', 'B']
        cnt = 0

# 남은거 털기 !
if cnt % 2 != 0:
    isPossible = False
elif cnt > 0:
    for i in range(n - cnt, n-3, 4):
        lst[i:i + 4] = ['A', 'A', 'A', 'A']
    if cnt % 4 == 2:
        lst[n - 2:n] = ['B', 'B']

if isPossible:
    print(*lst, sep='')
else:
    print(-1)
