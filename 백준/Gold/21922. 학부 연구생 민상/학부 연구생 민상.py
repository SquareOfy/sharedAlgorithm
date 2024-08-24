"""
d = 상 우 하 좌
1 : 홀수인 애들만 +2
2 : 짝수인 애들만 +2
3 : +3 mod
4 : +1 mod
물건 종류 별 방향 전환 정리
1
상 - 상 / 하 - 하
좌 - 우 / 우 - 좌

2
상 - 하 / 하 - 상
좌 - 좌 / 우 - 우
3
상 - 우 / 하 - 좌 +1
좌 - 하 / 우 - 상 +3

4
상 - 좌 / 하 - 우 +3
좌 - 상 / 우 - 하 +1
"""


def move(i, j, k):
    global answer
    visited[i][j] *= prime[k]
    if not ans_v[i][j]:
        ans_v[i][j] = 1
        answer += 1
    x = k
    d = dir[x]
    nr = i + d[0]
    nc = j + d[1]
    while nr in range(0, n) and nc in range(0, m):
        if visited[nr][nc]%prime[x] ==0:
            break
        visited[nr][nc] *= prime[x]
        if not ans_v[nr][nc]:
            ans_v[nr][nc] = 1
            answer += 1
        k = arr[nr][nc]
        if k == 1:
            if x % 2 == 1:
                x = (x + 2) % 4
                d = dir[x]
        elif k == 2:
            if x % 2 == 0:
                x = (x + 2) % 4
                d = dir[x]
        elif k == 3:
            if x % 2 == 0:
                x = (x + 1) % 4
                d = dir[x]

            else:
                x = (x + 3) % 4
                d = dir[x]

        elif k == 4:
            if x % 2 == 0:
                x = (x + 3) % 4
                d = dir[x]
            else:
                x = (x + 1) % 4
                d = dir[x]

        nr += d[0]
        nc += d[1]


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for i in range(n)]
dir = (-1, 0), (0, 1), (1, 0), (0, -1)
prime = [2,3,5,7]
answer = 0
ans_v = [[0] * m for i in range(n)]
visited = [[1] * m for i in range(n)]

for i in range(n):
    for j in range(m):
        if arr[i][j] == 9:
            for k in range(4):
                move(i, j, k)
# for i in range(n):
#     print(*ans_v[i])
print(answer)