n = int(input())
plan = list(map(int, input().split()))
study = list(map(int, input().split()))
answer = 0

for i in range(n):
    if plan[i]<=study[i]:
        answer+=1
print(answer)