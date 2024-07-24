from collections import deque

m, n, h = map(int, input().split())

#h - n - m 순
#위칸 상 좌 아래칸 하 우
d = ((-1, 0, 0), (0, -1, 0), (0, 0,-1), (1, 0, 0), (0,1,0), (0,0,1))

#1은 익은 토마토 0은 익지 않음 -1은 토마토 없음
#1인 곳이 상하 좌우 앞 뒤 여섯 방향의 토마토로 전파
arr = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]

#방문배열 1이면 방문 함
# visited = [[[0]*m for _ in range (n)] for _ in range(h)]


def check_tomato():
    for a in arr:
        for b in a:
            for c in b:
                if c == 0:
                    return False
    return True

q = deque([])
for k in range(h):
    for i in range(n):
        for j in range(m):
            if arr[k][i][j] == 1:
                q.append([k, i, j, 0])

answer = 0

while len(q)!=0 :
    now = q.popleft()
    rank = now[3]
    answer = rank
    for i in d:
        dw = now[0] + i[0]
        du = now[1] + i[1]
        dv = now[2] + i[2]
        if dw<0 or du<0 or dv<0 or dw>=h or du>=n or dv>=m:
            continue
        if arr[dw][du][dv] == 0:
            arr[dw][du][dv] = 1
            q.append([dw, du, dv, rank+1])


if check_tomato():
    print(answer)
else:
    print(-1)


