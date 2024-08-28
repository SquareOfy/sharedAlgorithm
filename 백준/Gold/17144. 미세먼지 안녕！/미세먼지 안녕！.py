"""

1614 문제 이해 완 / 구상시작
1618 코드 쓰기 시작 (돌풍청소 구현미흡,, 코드 머릿속에 바로 안그려짐 )
1642 구현 및 돌풍 방향 변경 부분 디버깅 후 제출
===============조건================

1초 동안 발생하는 일
    1. 먼지 확산
        상하좌우로 먼지 확산(배열 범위 내 / 돌풍 아닌 곳)
        확산양 원래칸 // 5만큼 확산 + 확산된만큼 그 칸 -
        동시에 발생하므로 확산 배열 따로 만들어두고 확산량 다 계산 후
        한번에 연산해서 원본 배열에 반영해야 함
        원본 배열에 반영할 때 sum 구해두기

    2. 돌풍 청소
        윗칸 반시계 이동
        아랫칸 시계 이동

        while문 4번쓰기? 배열 index?
        돌풍 윗칸부터 시작해서 윗칸 값을 자기 자리로 내리기 반복
        첫 시작 값을 전체 sum에서 빼기
        윗칸 없으면 방향 옆칸으로 바꾸기
        옆칸 없으면 아래칸으로 바꾸기
        아랫칸이 돌풍 아래칸의 행과 같으면 왼쪽으로 바꾸기
        (상, 우, 하, 좌) 순으로 옆에 있는 거 땡겨올 것
        최종으로 왼쪽이 돌풍이면 0으로 만들고 종료

        돌풍 아래칸 청소
        (하, 우, 상, 좌)
        최종으로 왼쪽이 돌풍이면 0 으로 만들고 종료
"""
def find_storm():
    for i in range(n):
        if arr[i][0]==-1:
            return i
n, m, t = map(int, input().split())
tc = 0
arr = [list(map(int, input().split())) for _ in range(n)]
up= find_storm()
down = up+1
tmp = [[0] * m for _ in range(n)]

while 1:
    if tc == t:
        break

    #먼지확산
    for i in range(n):
        for j in range(m):
            if arr[i][j] == -1:
                continue
            out = arr[i][j]//5
            for di, dj in (-1, 0), (0, -1), (1, 0), (0, 1):
                du = i + di
                dv = j + dj

                if du<0 or dv<0 or du>=n or dv>=m:
                    continue
                if arr[du][dv]==-1:
                    continue
                tmp[i][j]-=out
                tmp[du][dv]+= out
    #확산 합치기
    for i in range(n):
        for j in range(m):
            arr[i][j]+=tmp[i][j]
            tmp[i][j] = 0

    #돌풍 청소
    s = 0
    #윗칸 돌풍 위에 있는거 땡겨오기

    sr = up
    sc = 0
    for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
        while 1:
            if sr+di <0 or sr+di == down:
                break

            if sc+dj >=m or arr[sr+di][sc+dj] == -1:
                break
            if arr[sr][sc] != -1:
                arr[sr][sc] = arr[sr+di][sc+dj]
            sr += di
            sc += dj
            arr[sr][sc] = 0
    sr = down+1
    sc = 0
    s -= arr[sr][sc]  # 아랫칸 빨려들어감
    for di, dj in (1, 0), (0, 1), (-1, 0), (0, -1):
        while 1:
            if sr + di >= n or sr + di == up:
                break
            if sc + dj == m or arr[sr+di][sc+dj]==-1:
                break
            if arr[sr][sc] != -1:
                arr[sr][sc] = arr[sr + di][sc + dj]
            sr += di
            sc += dj
            arr[sr][sc] = 0

    tc += 1
#먼지 양 세기
answer = 0
for i in range(n):
    answer += sum(arr[i])
print(answer+2)