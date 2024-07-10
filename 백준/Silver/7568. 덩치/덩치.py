import sys

input = sys.stdin.readline

n = int(input())

people = []

for _ in range(n):
    man = list(map(int, input().split()))
    people.append(man)

result = [1]*n

for i in range(n):
    for j in range(i+1, n):
        if(people[i][0]<people[j][0]):
            if(people[i][1]<people[j][1]):
                result[i]+=1
        elif(people[i][0]>people[j][0]):
            if(people[i][1]>people[j][1]):
                result[j]+=1

for num in result:
    print(num, end = " ")