c, k, p = map(int, input().split())

answer = 0
for i in range(1, c+1):
    answer += k*i +p*(i**2)
print(answer)