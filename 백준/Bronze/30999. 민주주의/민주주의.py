n, m = map(int, input().split())
arr = [list(input()) for i in range(n)]
answer = 0
for i in range(n):
    cnt = arr[i].count('O')
    if cnt > m//2:
        answer += 1
print(answer)