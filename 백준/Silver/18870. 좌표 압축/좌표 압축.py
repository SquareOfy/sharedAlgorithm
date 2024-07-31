n = int(input())
lst = map(int, input().split())
lst2 = list(enumerate(lst))
lst2.sort(key = lambda x : x[1])

answer = [0] * n
for i in range(1, n):
    if lst2[i][1] != lst2[i-1][1]:
        answer[lst2[i][0]] = answer[lst2[i-1][0]]+1
    else:
        answer[lst2[i][0]] = answer[lst2[i-1][0]]


print(*answer)