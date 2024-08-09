n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
other_diagonal = [0]*(2*n-1)


def find_diagonal_idx(i, j):
    if i == j:
        return n - 1
    elif i < j:
        return n - 1 + (j - i)
    else:
        return n - 1 - (i - j)

def dfs(level, cnt):
    global answer
    if 2*n-1-level < answer-cnt:
        return
    if cnt == 2*n-2:
        answer = cnt
        return
    if level == 2*n:
        answer = max(answer, cnt)
        # print(selected)

        return
    l = abs(abs(level+1-n)-n)

    flag = False
    for i in range(l):
        # level 0 1 2 3 4 5 6 7 8
        #     r 0 1 2 3 4 4 4 4 4   시작
        #     c 0 0 0 0 0 1 2 3 4
        #     r 0 0 0 0 0 1 2 3 4   끝
        #     c 0 4 4 4 4 1 2 3 4
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
            # selected.append([r,c])
            dfs(level+1, cnt+1)
            other_diagonal[idx] = 0
            # selected.pop()
            flag = True

    if not flag:
        dfs(level+1, cnt) #그 줄에서 안고를 때??
answer = 0
# selected = []
dfs(0,0)
print(answer)




# def test(level):
#     return abs(abs(level + 1 - n) - n)
#
# for i in range(2*n-1):
#     print("i : ", i, ": ", test(i))



