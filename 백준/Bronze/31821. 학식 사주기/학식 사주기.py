n = int(input())
price = [int(input()) for _ in range(n)]
m = int(input())
corner = [int(input()) for _ in range(m)]
answer = 0
for i in range(m):
    answer += price[corner[i]-1]
print(answer)