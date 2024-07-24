w, h = map(int, input().split())

n = int(input())
answer = 0

shops = []
for i in range(n):
    shops.append(list(map(int, input().split())))

direction, dist = map(int, input().split())

for a in shops:
     if a[0] == direction:
         answer += abs(a[1] - dist)
     elif direction == 1: #북쪽
         if a[0] == 2: #남
             answer += h + min(dist + a[1], 2 * w-dist-a[1])
         elif a[0] == 3: #서
             answer += a[1] + dist
         else:
             answer += w-dist + a[1]
     elif direction == 2:
         if a[0] == 1: #북
             answer += h + min(dist + a[1], 2*w-dist-a[1])
         elif a[0] == 3: #서
             answer += h-a[1] + dist
         else:#동
             answer += w-dist + h-a[1]
     elif direction == 3:#서
         if a[0] == 1: #북
             answer += dist + a[1]
         elif a[0] == 2: #남
             answer += h-dist+a[1]
         else:#동
             answer += w+min(dist+a[1], 2*h-dist-a[1])
     elif direction ==4: #동
         if a[0] == 1: #북
             answer += dist+w-a[1]
         elif a[0] == 2: #남
             answer += h-dist+w-a[1]
         else: #서
             answer += w + min(a[1]+dist, 2*h-dist-a[1])

print(answer)


