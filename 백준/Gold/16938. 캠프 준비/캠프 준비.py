n, l, r, x = map(int, input().split())
lst = list(map(int, input().split()))


def select(cnt, k, idx):
    global answer
    if cnt == k:
        if l<=sum(selected)<=r and max(selected) - min(selected) >=x:
            answer+=1
        return

    for j in range(idx, n):
        if not visited[j]:
            visited[j] = 1
            selected.append(lst[j])
            select(cnt + 1, k, j + 1)
            selected.pop()
            visited[j] = 0


selected = []
visited = [0] * n
answer =0
for i in range(2, n + 1):
    select(0, i, 0)
print(answer)
