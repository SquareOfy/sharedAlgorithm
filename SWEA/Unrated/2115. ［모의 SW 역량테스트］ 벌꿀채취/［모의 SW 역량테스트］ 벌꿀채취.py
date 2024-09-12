def dfs(level):
    global answer

    if level==2:
        # 둘다 골랐으면 꿀 채집해보기
        answer = max(answer, collect_honey())
        return

    for i in range(n):
        for j in range(n - m+1):
            if 1 in visited[i][j:j + m]:
                continue
            visited[i][j:j + m] = [1] * m
            selected[level][:] =[i, j]
            dfs(level + 1)
            visited[i][j:j + m] = [0] * m

def comb(lst, k, level, idx, honey_lst):
    global s
    if level == k:
        if sum(honey_lst) <= c:
            tmp = 0
            for i in honey_lst:
                tmp+= i**2
            s = max(tmp, s)

        return
    for i in range(idx, m):
        comb(lst, k, level+1, i+1, honey_lst+[lst[i]])


def collect_honey():
    global s
    i, j = selected[0]
    y, x = selected[1]
    lst1 = arr[i][j:j + m]
    lst2 = arr[y][x:x + m]
    #
    # print(i, j)
    # print(lst1)
    s1 = sum(lst1)
    s2 = sum(lst2)
    result = 0
    if s1>c:
        s = 0
        for k in range(m-1, 0, -1):
            comb(lst1, k, 0, 0, [])

        result += s
    else:
        for k in lst1:
            result += k**2

    if s2>c:
        s = 0
        for k in range(m-1, 0, -1):
            comb(lst2, k, 0, 0, [])
        result+=s
    else:
        for k in lst2:
            result+= k**2

    return result

t = int(input())
for tc in range(1, t + 1):
    n, m, c = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    selected = [[0] * 2 for _ in range(2)]  # 각각 채집 시작 좌표
    visited = [[0] * n for _ in range(n)]
    answer = 0
    s = 0
    tmp_answer  = 0
    dfs(0)
    print(f"#{tc} {answer}")