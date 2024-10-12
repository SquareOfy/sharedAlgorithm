def dfs(r, c, lst):
    global mx, mn
    if r == N - 1 and c == N - 1:
        v = cal_value(lst)
        mx = max(mx, v)
        mn = min(mn, v)
        return

    for di, dj in (0, 1), (1, 0):
        du, dv = r+di, c+dj
        if du<0 or dv<0 or du>=N or dv>=N:
            continue
        if visited[du][dv]:
            continue

        visited[du][dv] = 1
        dfs(du, dv, lst+[arr[du][dv]])
        visited[du][dv] = 0


def cal_value(lst):
    v = int(lst[0])
    for i in range(2, len(lst), 2):
        v = calculate(int(v), int(lst[i]), lst[i - 1])
    return v


def calculate(a, b, o):
    if o == '+':
        return a + b
    elif o == '-':
        return a - b
    else:
        return a * b


N = int(input())
arr = [list(input().split()) for _ in range(N)]
mx = -float('inf')
mn = float('inf')

visited = [[0] * N for _ in range(N)]
dfs(0, 0, [arr[0][0]])
print(mx, mn)