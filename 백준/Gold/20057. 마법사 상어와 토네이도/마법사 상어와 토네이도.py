import sys
input = sys.stdin.readline
d_dict = [{(-2, 0): 2, (-1, -1): 10, (-1, 0): 7, (-1, 1): 1, (0, -2): 5, (1, -1): 10, (1, 0): 7, (1, 1): 1, (2, 0): 2},\
          {(0, -2): 2, (1, -1): 10, (0, -1): 7, (-1, -1): 1, (2, 0): 5, (1, 1): 10, (0, 1): 7, (-1, 1): 1, (0, 2): 2}, \
          {(2, 0): 2, (1, 1): 10, (1, 0): 7, (1, -1): 1, (0, 2): 5, (-1, 1): 10, (-1, 0): 7, (-1, -1): 1, (-2, 0): 2},\
          {(0, 2): 2, (-1, 1): 10, (0, 1): 7, (1, 1): 1, (-2, 0): 5, (-1, -1): 10, (0, -1): 7, (1, -1): 1, (0, -2): 2}]

dir = (0, -1), (1, 0), (0, 1), (-1, 0)
answer = 0

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

sr, sc = n // 2, n//2
l = 1
cnt = 0
d_idx = 0
while 1:
    if sr == 0 and sc == 0:
        break
    di, dj = dir[d_idx]
    for i in range(l):
        sr += di
        sc += dj
        sand = arr[sr][sc]
        for k, v in d_dict[d_idx].items():
            du = sr + k[0]
            dv = sc + k[1]
            spread_sand = (sand * v//100)
            arr[sr][sc] -= spread_sand
            if du < 0 or dv < 0 or du >= n or dv >= n:
                answer += spread_sand
                continue
            arr[sr + k[0]][sc + k[1]] += spread_sand
        du = sr + dir[d_idx][0]
        dv = sc + dir[d_idx][1]
        if du < 0 or dv < 0 or du >= n or dv >= n:
            answer += arr[sr][sc]
        else:
            arr[du][dv] += arr[sr][sc]
        arr[sr][sc] = 0

        if sr == 0 and sc == 0:
            break
    cnt += 1
    if cnt == 2:
        l += 1
        cnt = 0
    d_idx = (d_idx + 1) % 4
print(answer)
