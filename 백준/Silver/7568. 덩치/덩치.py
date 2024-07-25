n = int(input())
people = [list(map(int, input().split()))+[i] for i in range(n)]

people.sort(key = lambda x : (x[0],x[1]), reverse=True)
answer = [1]*n
for i in range(n):
    for j in range(i):
        if people[j][0] > people[i][0] and people[j][1] > people[i][1]:
            answer[people[i][2]]+=1

print(*answer)
