n, l, r, x = map(int, input().split())
lst = list(map(int, input().split()))


def dfs(level, selected):
    global answer
    if level == n:
        if len(selected)<=1:
            return
        if l <= sum(selected) <= r and max(selected) - min(selected) >= x:
            answer += 1
        return
    dfs(level + 1, selected + [lst[level]])
    dfs(level + 1, selected)


answer = 0
dfs(0, [])
print(answer)
