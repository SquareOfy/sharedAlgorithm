n, m = map(int, input().split())
lst = list(set(list(map(int, input().split()))))
lst.sort()
def dfs(cnt, idx, selected):
    if cnt == m:
        print(*selected)
        return

    for i in range(idx, len(lst)):
        dfs(cnt+1, i, selected+[lst[i]])

dfs(0, 0, [])

