n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*n for _ in range(n)]
answer = 200*100


def check_place(r, c):
    if visited[r][c] == 1:
        return False, 0
    result = arr[r][c]
    for d in ((-1, 0), (0, -1), (1, 0), (0, 1)):
        du = r+d[0]
        dv = c+d[1]
        if visited[du][dv] == 1:
            return False, 0
        result+= arr[du][dv]
    return True, result


def update_visited(r, c, i):
    # tmp = arr[r][c]
    visited[r][c] = i
    for d in ((-1, 0), (0, -1), (1, 0), (0, 1)):
        du = r+d[0]
        dv = c+d[1]
        visited[du][dv] =i


def pick(cnt, sm):
    global answer
    if cnt == 3:
        answer = min(answer, sm)
        return

    for i in range(1, n-1):
        for j in range(1, n-1):
            possible, tmp = check_place(i,j)
            if possible:
                update_visited(i, j, 1)
                pick(cnt+1, sm+tmp)
                update_visited(i, j, 0)

pick(0, 0)
print(answer)