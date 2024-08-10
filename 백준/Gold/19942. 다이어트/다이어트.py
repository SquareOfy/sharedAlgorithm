def dfs(level, sp, sf, ss, sv, cost, selected):
    global answer_cost, answer
    if cost > answer_cost:
        return
    if level == n or (sp>=mp and sf >= mf and ss>=ms and sv>=mv):
        if sp<mp or sf <mf or ss<ms or sv<mv:
            return
        if answer_cost > cost:
            answer_cost = cost
            answer = selected
        return

    dfs(level+1, sp+arr[level][1][0], sf+arr[level][1][1], ss+arr[level][1][2], sv+arr[level][1][3], cost+arr[level][1][4], selected+[arr[level][0]+1])
    dfs(level+1, sp, sf, ss, sv, cost, selected)


n = int(input())
mp, mf, ms, mv = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
answer =[]
answer_cost = 500*15+1
arr = list(enumerate(arr))
# arr.sort(key = lambda x : (x[1][4], x[0]))
# print(arr)
dfs(0, 0, 0, 0, 0, 0, [])

if answer != []:
    answer.sort()
    print(answer_cost)
    print(*answer)
else:
    print(-1)