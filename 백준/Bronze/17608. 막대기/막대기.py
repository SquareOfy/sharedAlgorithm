n = int(input())

sticks = [int(input()) for _ in range(n)]
cnt = 1
max_num = sticks[n-1]

for i in range(n-2, -1, -1):
    if max_num < sticks[i]:
        cnt += 1
        max_num = sticks[i]
print(cnt)