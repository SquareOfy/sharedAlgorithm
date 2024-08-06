lst = list(map(int, input().split()))

selected = [0]*10
answer = 0
def dfs(level, score):
    global answer
    if 10 - level < 5-score:
        return
    if level==10:
        if score >= 5:
            answer +=1
        return

    for i in range(1, 6):
        if level>=2:
            if selected[level-2]==selected[level-1]==i:
                continue
        selected[level] = i
        if lst[level] == i:
            dfs(level+1, score+1)
        else:
            dfs(level+1, score)

dfs(0, 0)
print(answer)
