def dfs(cnt, y_cnt, r, c, selected):
    # s_cnt = 0
    # for p in selected:
    #     if arr[p[0]][p[1]] == 'Y':
    #         s_cnt += 1
    #     if s_cnt >= 4:
    #         return
    if y_cnt > 3:
        return

    if cnt == 7:
        selected.sort()
        selected = tuple(selected)
        if selected in answer_set:
            return
        answer_set.add(selected)
        return

    # for d in directions:
    #     du = r + d[0]
    #     dv = c + d[1]
    #     if du < 0 or dv < 0 or du >= 5 or dv >= 5:
    #         continue
    #     if (du, dv) in selected:
    #         continue
    #     y = 0
    #     if arr[du][dv] == 'Y':
    #         y = 1
    #     if y + y_cnt >= 4:
    #         continue
    #     # visited[du][dv] = 1
    #     dfs(cnt + 1, y_cnt + y, du, dv, selected + [(du, dv)])
    #     # visited[du][dv] = 0

    for p in selected:
        for d in directions:
            du = p[0] + d[0]
            dv = p[1] + d[1]
            if du < 0 or dv < 0 or du >= 5 or dv >= 5:
                continue

            if (du , dv) in selected:
                continue
            y = 0
            if arr[du][dv] == 'Y':
                y = 1
            if y+y_cnt >= 4:
                continue
            dfs(cnt + 1, y_cnt + y, du, dv, selected + [(du, dv)])


arr = [list(input()) for _ in range(5)]
directions = (1, 0), (0, 1), (-1, 0), (0, -1)
# visited = [[0] * 5 for _ in range(5)]
answer_set = set()
for i in range(5):
    for j in range(5):
        y_cnt = 0
        if arr[i][j] == 'Y':
            continue
        dfs(1, 0, i, j, [(i, j)])
print(len(answer_set))

