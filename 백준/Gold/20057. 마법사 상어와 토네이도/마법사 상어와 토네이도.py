# 0, 1, 2, 3일 때 dic 넣어서
# 각 좌표에서 몇 %인지 나오게 하기


# 좌 하 우 상 순
d_dict = [{(-2, 0): 0.02, (-1, -1): 0.1, (-1, 0): 0.07, (-1, 1): 0.01, (0, -2): 0.05, (1, -1): 0.1, (1, 0): 0.07, (1, 1): 0.01, (2, 0): 0.02},\
          {(0, -2): 0.02, (1, -1): 0.1, (0, -1): 0.07, (-1, -1): 0.01, (2, 0): 0.05, (1, 1): 0.1, (0, 1): 0.07, (-1, 1): 0.01, (0, 2): 0.02}, \
          {(2, 0): 0.02, (1, 1): 0.1, (1, 0): 0.07, (1, -1): 0.01, (0, 2): 0.05, (-1, 1): 0.1, (-1, 0): 0.07, (-1, -1): 0.01, (-2, 0): 0.02},\
          {(0, 2): 0.02, (-1, 1): 0.1, (0, 1): 0.07, (1, 1): 0.01, (-2, 0): 0.05, (-1, -1): 0.1, (0, -1): 0.07, (1, -1): 0.01, (0, -2): 0.02}]

dir = (0, -1), (1, 0), (0, 1), (-1, 0)
answer = 0

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# 토네이도 이동 구현하기
sr, sc = n // 2, n//2
l = 1
cnt = 0
d_idx = 0
while 1:
    if sr == 0 and sc == 0:
        break
    # 현재 방향으로 l만큼 토네이도 및 모래 이동하고
    # l만큼을 두번 갔다면! l+1시키기
    # 방향도 매번 회전하기
    di, dj = dir[d_idx]
    for i in range(l):
        # 토네이도 이동
        sr += di
        sc += dj
        sand = arr[sr][sc]
        # sr, sc에 있는 모래를 여기를 기준으로 이동
        for k, v in d_dict[d_idx].items():
            du = sr + k[0]
            dv = sc + k[1]
            spread_sand = int(sand * v)
            arr[sr][sc] -= spread_sand
            if du < 0 or dv < 0 or du >= n or dv >= n:
                answer += spread_sand
                continue
            arr[sr + k[0]][sc + k[1]] += spread_sand
        # 모래 다 옮기고 나서 alpha 칸으로 남은 모래 전부 옮기기
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

# 토네이도 이동 속의 모래 이동
# 현재 보는 방향의 y좌표를 중심으로 d_dict에서 꺼내서 계산하기
# 바운더리 벗어나면 answer에다 더하기


# 룩업테이블 만드는 코드
# first = {(-2,0):0.02, (-1, -1):0.1, (-1, 0): 0.07, (-1, 1): 0.01, \
#          (0, -2):0.05, (1, -1) : 0.1, (1, 0):0.07, (1, 1) : 0.01, (2,0):0.02}
# d_dict = [first]
# def rotate(point):
#     return -point[1], point[0]
# for i in range(3):
#     new_dict = {}
#     for k, v in d_dict[-1].items():
#         new_dict[rotate(k)] = v
#
#     d_dict.append(new_dict)
# print(d_dict)
