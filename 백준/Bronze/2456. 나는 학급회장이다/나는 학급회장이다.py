n = int(input())
votes = [[0]*3 for _ in range(3)]

for i in range(n):
    lst = list(map(int, input().split()))
    for i in range(3):
        votes[i][lst[i]-1] += 1
new_votes = [(i, x) for i,x in enumerate(votes)]

new_votes.sort(reverse = True, key = lambda x : (x[1][2]*3+x[1][1]*2+x[1][0], x[1][2], x[1][1]))
answer = new_votes[0][1][2]*3+new_votes[0][1][1]*2+new_votes[0][1][0]
if answer == new_votes[1][1][2]*3+new_votes[1][1][1]*2+new_votes[1][1][0] \
        and new_votes[0][1][1] == new_votes[1][1][1] and new_votes[0][1][2] == new_votes[1][1][2]:
    print(0, answer)
else:
    print(new_votes[0][0]+1, answer)