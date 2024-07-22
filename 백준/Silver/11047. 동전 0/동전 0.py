n, k = map(int, input().split())
coins = [int(input()) for i in range(n)]

idx = -1
for i in range(n):
    if coins[i] > k:
        idx = i-1
        break

cnt = 0
for j in coins[idx::-1]:
    cnt += k // j
    k = k % j
    if k == 0:
        break
print(cnt)