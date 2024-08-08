n, m = map(int, input().split())
lst = list(map(int, input().split()))
idx_lst = [1] * n
lst.sort()

for i in range(n):
    if i > 0 and lst[i] == lst[i - 1]:
        idx_lst[i] = idx_lst[i - 1] + 1


def dfs(cnt, selected):
    if cnt == m:
        print(*selected)
        return

    for i in range(n):
        if visited[i]:
            continue

        # 현재까지 사용한 lst[i]의 개수와 내가 보고 있는 lst[i]가 몇번째 lst[i]인지를        
        # 비교하여 들어가도 되는지 판단
        if lst[i] in selected and selected.count(lst[i]) + 1 < idx_lst[i]:
            continue
        if lst[i] not in selected and idx_lst[i] != 1:
            continue
        visited[i] = 1
        dfs(cnt + 1, selected + [lst[i]])
        visited[i] = 0


visited = [0] * n
dfs(0, [])
