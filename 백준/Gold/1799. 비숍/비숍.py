n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
other_diagonal = [0]*(2*n-1)


def find_diagonal_idx(i, j):
    return n-1+j-i


def dfs(level, cnt):
    global answer
    if 2*n-1-level < answer-cnt:
        return
    if answer == 2*n-2:
        return
    if level == 2*n:
        answer = max(answer, cnt)
        # print(selected)

        return
    l = abs(abs(level+1-n)-n)

    flag = False
    for i in range(l):
        r= -1
        c= -1
        if level <=n-1:
            r = level-i
            c = l-r-1
        else:
            r = n-1-i
            c = level-r

        if arr[r][c] == 1:
            idx = find_diagonal_idx(r, c)

            if other_diagonal[idx]:
                continue
            other_diagonal[idx] = 1
            dfs(level+1, cnt+1)
            other_diagonal[idx] = 0
            flag = True

    if not flag:
        dfs(level+1, cnt) #그 줄에서 안고를 때??

answer = 0
dfs(0,0)
print(answer)



