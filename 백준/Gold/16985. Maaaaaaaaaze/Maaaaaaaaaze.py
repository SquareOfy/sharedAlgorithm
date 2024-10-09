from collections import deque


def oob(z, y, x):
    return z < 0 or y < 0 or x < 0 or z >= 5 or y >= 5 or x >= 5


def bfs(arr):
    q = deque([(0, 0, 0, 1)])
    arr[0][0][0] = 1

    while q:
        cz, cy, cx, rank = q.popleft()
        if rank > answer:
            return rank
        if cz == 4 and cy == 4 and cx == 4:
            return rank - 1

        for dz, dy, dx in DIR:
            nz, ny, nx = cz + dz, cy + dy, cx + dx
            if oob(nz, ny, nx):
                continue
            if arr[nz][ny][nx] == 0:
                continue
            arr[nz][ny][nx] = 0
            q.append((nz, ny, nx, rank + 1))

    return inf
def find_same_arr():
    for m in range(idx):
        for j in range(4):
            if arr[m][j] == input_arr:
                cnt_arr[m]+=1
                num_lst[n] = m
                return True
    return False

def dfs(level, lst):
    global answer
    if level == 5:
        new_arr = [[] for _ in range(5)]
        for k in range(5):
            new_arr[k] = [arr[lst[k][0]][lst[k][1]][t][:] for t in range(5)]
        if tuple(lst) in s:
            return
        s.add(tuple(lst))
        cnt = bfs(new_arr)
        answer = min(cnt, answer)
        return

    for i in range(5):
        num = num_lst[i]
        if visited[i]: continue
        if cnt_arr[num] ==0: continue
        for j in range(4):
            if level == 0 and arr[num][j][0][0] == 0: continue
            if level == 4 and arr[num][j][4][4] == 0: continue
            cnt_arr[num] -= 1
            visited[i] = 1
            dfs(level + 1, lst + [(num, j)])
            cnt_arr[num] += 1
            visited[i]=0

arr = [[None] * 4 for _ in range(5)]
DIR = (1, 0, 0), (-1, 0, 0), (0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1)
idx = 0
cnt_arr=[]
num_lst = [0]*5
for n in range(5):
    input_arr = [list(map(int, input().split())) for _ in range(5)]

    #회전했을 때 같은 애 있나 찾으렴
    is_same = find_same_arr()
    if is_same:
        continue

    cnt_arr.append(1)
    num_lst[n] = idx
    arr[idx][0] = [input_arr[i][:] for i in range(5)]

    for i in range(1, 4):
        arr[idx][i] = list(map(list, zip(*arr[idx][i - 1][::-1])))
    idx+=1
visited = [0] * 5
inf = 5 * 5 * 5 + 1
answer = inf
s = set()
dfs(0, [])
print(answer if answer != inf else -1)