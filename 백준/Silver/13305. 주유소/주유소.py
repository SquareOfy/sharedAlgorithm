n = int(input())

roads = list(map(int, input().split()))
cities = list(map(int, input().split()))

min_price = cities[0]
dist = 0
answer =0
for i in range(1, n):
    dist += roads[i-1]
    answer += dist*min_price
    dist = 0
    if cities[i] < min_price:
        min_price = cities[i]
print(answer)