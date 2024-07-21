candidate = []
selected = []
visited = [0] * 9
flag = False
for _ in range(9):
    candidate.append(int(input()))


def brute_force(cnt, idx, sum):
    global flag
    if flag: return
    if cnt == 7:
        if sum == 100:
            flag = True
            selected.sort()
            print(*selected, sep="\n")
        return

    for i in range(idx, 9):
        if visited[i] != 0: continue
        visited[i] = 1
        selected.append(candidate[i])
        brute_force(cnt + 1, i + 1, sum + candidate[i])
        visited[i] = 0
        selected.pop()
        brute_force(cnt, i + 1, sum)


brute_force(0, 0, 0)