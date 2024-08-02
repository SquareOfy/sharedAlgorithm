n = int(input())

meetings = [list(map(int, input().split())) for _ in range(n)]

meetings.sort(key=lambda x:(x[1], x[0]))

cnt = 0
last = 0
for i in range(n):
    if meetings[i][0]>=last:
        cnt+=1
        last = meetings[i][1]
print(cnt)
