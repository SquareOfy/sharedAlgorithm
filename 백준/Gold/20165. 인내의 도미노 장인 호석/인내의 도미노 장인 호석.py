#dfs함수(도미노 연쇄적으로 넘어뜨리는 함수)
def dfs(r, c, d):
    global cnt
    cnt+=1
    visited[r][c] = 1
    # print(r, c)
    # print(arr[r][c])

    n = arr[r][c]
    du, dv = r, c
    for i in range(n-1):
        du+= d[0]
        dv +=d[1]
        if du<0 or dv<0 or du>=N or dv>=M:
            continue
        if visited[du][dv]:
            continue
        dfs(du, dv, d)

#입력받기
N, M, R = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0]*M for _ in range(N)]

dir_dic = {'E':(0, 1), 'W' : (0, -1), 'N':(-1, 0), 'S':(1, 0)}
answer = 0
#공격/수비 라운드
for t in range(R):
    #공격 : dfs 호출
    r, c, d = input().split()
    r = int(r)-1
    c = int(c)-1
    d = dir_dic[d]
    cnt = 0
    if not visited[r][c]:
        dfs(r, c, d)

    #수비
    #visited == 1 이면 0으로 바꾸고 tmp -= 1
    i, j = map(int, input().split())
    i-=1
    j-=1
    if visited[i][j]:
        visited[i][j] = 0

    # 이번 라운드에서 얻은 점수 합산하기
    answer += cnt
print(answer)
for i in range(N):
    for j in range(M):
        if visited[i][j]:
            print('F', end = " ")
        else:
            print('S', end=" ")
    print()

