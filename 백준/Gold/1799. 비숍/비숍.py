n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
other_diagonal = [0]*(2*n-1)


def dfs(level, cnt):
    global answer
    if answer == 2*n - 2:
        return
    if cnt == 2*n-2:
        answer = cnt
        return
    if cnt + (2*n - level) < answer:
        return
    if level == 2*n:
        answer = max(answer, cnt)
        return

    if level < n:
        l = level + 1
    else:
        l = 2*n - (level + 1)

    flag = True
    for i in range(l):
        if level < n:
            r = level - i
            c = i
        else:
            r = (n - 1) - i
            c = level -r
        if arr[r][c] == 1:
            idx = (n - 1) + (c - r)
            if other_diagonal[idx]:
                continue
            flag = False
            other_diagonal[idx] = 1
            dfs(level+1, cnt+1)
            other_diagonal[idx] = 0
    if flag:
        dfs(level+1, cnt) #그 줄에서 안고를 때??


answer = 0
dfs(0,0)
print(answer)