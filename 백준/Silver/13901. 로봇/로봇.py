def set_dir_idx(i):
    return int(i) - 1


# 문제이해 : 3시 16분 ~ 23분
# 구현 : ~30
# 디버깅 : ~57분
# 입력받기
n, m = map(int, input().split())


# 장애물 입력받기 및 배열 표시
k = int(input())  # 장애물 개수
visited = [[0] * m for _ in range(n)]  # visited 변수 기본값 0 , 장애물 1, 이동한 곳 1 표기
for i in range(k):
    br, bc = map(int, input().split())
    visited[br][bc] = 1

sr, sc = map(int, input().split())
visited[sr][sc] = 1



dir = (-1, 0), (1, 0), (0, -1), (0, 1) # 상하좌우
# 사용자 지정 방향 #인덱스로 지정하기 위해 -1 빼서 사용할 것
my_dir = list(map(set_dir_idx, input().split()))
mod = len(my_dir)
d_idx = 0  # 현재보고 있는 방향을 가리키는 인덱스 d_idx 에 저장


# while 문 사용 종료될때까지
flag = True
while flag:
    tmp = 0
    # 이동한 횟수를 나타내는 변수 tmp +1
    #현재방향부터 한바퀴를 돌아보기
    for i in range(mod):
        #현재 방향에서 갈 수 있으면 쭈우우우욱 가세요
        while 1:
            d = dir[my_dir[d_idx]]
            du = sr + d[0]
            dv = sc + d[1]
            #갈수 없으면 방향을 돌린다
            if du < 0 or dv < 0 or du >= n or dv >= m or visited[du][dv]:
                d_idx = (d_idx + 1) % mod
                break
            visited[du][dv] = 1
            sr, sc = du, dv
            tmp += 1
        #방향 다 돌렸는데 움직임이 없었다
        if i==mod-1 and tmp==0:
            flag = False
            break
print(sr, sc)
