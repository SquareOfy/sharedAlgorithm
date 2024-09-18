"""
모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
    이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
    같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
    파이어볼은 4개의 파이어볼로 나누어진다.
    나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
        질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
        속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
        합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
        질량이 0인 파이어볼은 소멸되어 없어진다.

파이어볼 관리 방법 ,,
3차원으로 [m, s, d] 넣어서 관리하기  이걸로 ㄱ
dict에 (r, c)를 key로 넣어서 관리하기 ? 한 칸에 여러개 있을 수 있으므로 이건 안됨

for k in range(K)
    #파이어볼 이동시키기 (동시에 이동 돼야 하므로!!! 따로 배열 만들기)

    #배열 탐색 - 파이어볼 두개 이상이면
    개수 l
    질량 합 sm
    속력 합 ss
    모두 홀수, 짝수여부 확인

"""
#입력
#배열에 파이어볼 넣기..
N, M, K = map(int, input().split())
arr = [[[] for _ in range(N)] for _ in range(N)]

dir = (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)
for m in range(M):
    r, c, m, s, d = map(int, input().split())
    arr[r-1][c-1].append([m, s, d])

###############33
# 1, N 연결됨 주의 !!!!!!!!!!!!!!!!!!!!!!!!

for k in range(K):
    # 파이어볼 이동시키기 (동시에 이동 돼야 하므로!!! 따로 배열 만들기)
    new_arr = [[[] for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not arr[i][j]:
                continue
            for m, s, d in arr[i][j]:
                di, dj = dir[d]
                du = i+di*s
                dv = j+dj*s

                # N-1과 0 연결. 1에서 더 가는건 어차피 음수로 처리됨
                du%=N
                dv%=N

                new_arr[du][dv].append([m, s, d])

    arr = [[[] for _ in range(N)] for _ in range(N)]

    #이동된 애들 (new_arr) 두개 이상이면 합치고 나누기
    for i in range(N):
        for j in range(N):
            if len(new_arr[i][j])==1:
                arr[i][j] = new_arr[i][j][:]
            elif len(new_arr[i][j]) >=2:
                l = len(new_arr[i][j]) #개수
                sm = 0
                ss = 0
                d_remainder = 0
                for m, s, d in new_arr[i][j]:
                    sm+=m
                    ss+=s
                    d_remainder += d%2

                next_m = sm//5
                next_s = ss//l
                if next_m == 0:
                    continue
                if d_remainder == l or d_remainder==0:
                    d_lst = [0, 2, 4, 6]
                else:
                    d_lst = [1, 3, 5, 7]
                for d in d_lst:
                    arr[i][j].append([next_m, next_s, d])
answer = 0
for i in range(N):
    for j in range(N):
        for m, s, d in arr[i][j]:
            answer+=m
print(answer)


    # 배열 탐색 - 파이어볼 두개 이상이면
#     개수 l
#     질량 합 sm
#     속력 합 ss
#     모두 홀수, 짝수여부 확인