n = int(input())
cards = list(map(int, input().split()))
m = int(input())
goal = list(map(int, input().split()))
answer = []

min_value = 10000000
max_value = -1000000

for i in cards:

    if i>max_value:
        max_value= i
    if i<min_value:
        min_value = i

cnt_lst = [0]*(max_value-min_value+2)


for i in cards:

    cnt_lst[i-min_value] += 1

for i in goal:
    if i>max_value or i<min_value:
        answer.append(0)
    else:
        answer.append(cnt_lst[i-min_value])


print(*answer)