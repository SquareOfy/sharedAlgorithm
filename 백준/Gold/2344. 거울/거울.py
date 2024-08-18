def move(cur, d):
    r, c = cur
    r+=d[0]
    c+=d[1]

    while 0<r<=n and 0<c<=m:
        if arr[r][c] == 1:
            d = change_dir(d)
        r+= d[0]
        c+= d[1]
    return arr[r][c]

def change_dir(d):
    return (-d[1], -d[0])

#거울을 만나면 방향이 바뀜
#오른쪽으로 가던건 위로, 아래로 가던건 왼쪽으로
#위로 가던건 오른쪽으로, 왼쪽으로 가던건 아래로

# (-1, 0) <-> (0, 1)
# (0, -1) <-> (1, 0)


#arr 마진 넣어 잡고 테두리만 for문으로 돌기

n, m = map(int, input().split())
arr = [[0]*(m+2)] + [[0] + list(map(int, input().split()))+[0] for i in range(n)] +[[0]*(m+2)]
answer = []
num_dict = {}
idx = 1
for i in range(1, n+1):
    arr[i][0] = idx
    idx+=1
for j in range(1, m+1):
    arr[n+1][j] = idx
    idx+=1
for i in range(n, 0, -1):
    arr[i][m+1] = idx
    idx+=1
for j in range(m, 0, -1):
    arr[0][j] = idx
    idx+=1


# c = 0 라인 : 오른쪽으로 빛 쏘기
for i in range(1, n+1):
    now = [i, 0]
    answer.append(move(now, (0, 1)))

# r= n 라인 : 위로 쏘기
for j in range(1, m+1):
    now = [n+1, j]
    answer.append(move(now, (-1, 0)))
# c = m+1 라인 : 왼쪽으로 쏘기
for i in range(n, 0, -1):
    now = [i, m+1]
    answer.append(move(now, (0, -1)))
# r = 0 라인 아래로 쏘기
for j in range(m, 0, -1):
    now = [0, j]
    answer.append(move(now, (1, 0)))

print(*answer)