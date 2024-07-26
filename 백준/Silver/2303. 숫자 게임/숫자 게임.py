n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]
max_module = 0
max_sum = 0
answer = -1
for t in range(n):
    cards = arr[t]
    for i in range(3):
        for j in range(i+1, 4):
            for k in range(j+1, 5):
                tmp = cards[i] + cards[j] + cards[k]
                if tmp%10 >= max_module:
                    max_module = tmp%10
                    answer = t+1


print(answer)