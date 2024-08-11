def find_place():
    r_len = len(sticker)
    c_len = len(sticker[0])
    # arr에서 스티커를 붙일 수 있는 가장 위쪽, 가장 왼쪽 자리 return하는 함수
    # sticker를 붙이는게 가능한 시작 지점
    for i in range(n - r_len + 1):
        for j in range(m - c_len + 1):
            # i, j를 가장 왼쪽 끝으로 했을 때 스티커 붙일 수 있을까?
            if check(i, j, r_len, c_len):
                return i, j
    # 이 스티커로 붙일 수 있는 위치가 없으면 r, c 모두 -1 반환
    return -1, -1


def check(i, j, r_len, c_len):
    for y in range(r_len):
        for x in range(c_len):
            if arr[i + y][j + x] == 1 and sticker[y][x] == 1:
                return False
    return True


def put_sticker(i, j):
    r_len = len(sticker)
    c_len = len(sticker[0])
    for y in range(r_len):
        for x in range(c_len):
            if arr[i+y][j+x] == 0:
                arr[i + y][j + x] = sticker[y][x]


def rotate():
    global sticker
    return list(zip(*sticker[-1::-1]))


n, m, k = map(int, input().split())
arr = [[0] * m for _ in range(n)]

for i in range(k):
    r, c = map(int, input().split())
    sticker = [list(map(int, input().split())) for _ in range(r)]

    # 1단계에서 스티커 붙일 수 있는 자리 체크
    st_i, st_j = find_place()
    if st_i != -1 and st_j != -1:
        # 1단계 자리 있다면 그 자리에 스티커 붙이기
        put_sticker(st_i, st_j)
    else:
        # 1단계 없다면, 회전 90도씩 해서 붙일 수 있는 곳 자리 체크
        # 붙일 수 있다면 붙이기
        rotate_cnt= 0
        while (rotate_cnt < 3):
            # 90도 회전
            sticker = rotate()

            # 스티커 위치 찾기
            st_i, st_j = find_place()

            # 붙일 수 있으면 붙이고 break
            if st_i!=-1 and st_j!=-1:
                put_sticker(st_i, st_j)
                break
            rotate_cnt += 1

answer = 0

for i in range(n):
    answer += arr[i].count(1)
print(answer)