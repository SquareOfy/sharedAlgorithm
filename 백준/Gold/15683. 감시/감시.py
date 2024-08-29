"""
1502 문제읽기 시작
1506 문제정리 완료. 구상시작

===============구상==================
갈 수 없는 칸 합의 최솟값이므로
visited로 방문 가능한 칸 1 처리 후 sum(visited)를 최대로 만든 후,
최종적으로 n*m - sum(visited)를 출력하기

1~5인 칸의 (행, 열) list로 받아두고
상하좌우 중 어디를 바라볼지 백트래킹으로 정하기
1~5가 각각 갈 수 있는 방향 미리 룩업테이블에 저장해두기

정할 때마다 그 방향에서 볼 수 있는 곳 체크 (0에서 1로바꿀 경우 cnt로 들고다니기)

5인 경우는 그냥 어딜 봐도 상하좌우이므로 실행

갈 수 있는 방향으로 쭉 가다가 oob거나 6만나면 stop
while문으로 동작하기

===============문제 정리=============
1 한쪽
2 양쪽(반대로)
3 두방향(수직)
4 세방향
5 네방향

각 말이 바라보고 있는 방향에 따라 이동할 수 있는 방향, 범위 달라짐
각 말들이 바라보는 방향을 설정하여 갈 수 없는 격자의 크기 최소화하기
최대한 많이 갈 수 있게 만들기

본인의 말 뛰어넘기 가능
상대의 말 뛰어넘기 불가

입력 n, m (직사각형 주의)
6은 상대편 말

arr에 1~5의 말 종류가 주어짐  0은 빈칸

"""
def dfs(level):
    global answer
    if level==chess_len:
        cnt = 0
        for i in range(n):
            for j in range(m):
                if visited[i][j]==0 and arr[i][j] != 6:
                    cnt+=1
        # for i in range(n):
        #     print(visited[i])
        # print()
        answer = min(cnt, answer)

        return

    cr, cc = lst[level]
    chess =arr[cr][cc] #chess 종류
    range_num = dir_range_lst[chess] #체스 종류에 따른 백트래킹 후보 종류 range 범위

    for j in range(range_num):
        #이 방향으로 바라봐보기
        check_visited(cr, cc, j, 1)
        visited[cr][cc]+=1
        dfs(level+1)
        visited[cr][cc]-=1
        check_visited(cr, cc, j, -1)

def check_visited(r, c, j, k):
    cnt = 0

    # visited[r][c] += k
    for di, dj in dir[arr[r][c]][j]:
        du, dv = r, c
        #d방향으로 갈 수 있을 때까지 체크하기
        #체크한 경우 값도 count
        while 1:
            du+= di
            dv+= dj

            if du <0 or dv<0 or du>=n or dv>=m:
                break
            if arr[du][dv]==6:
                break
            # if visited[du][dv] ==0 and k>0:
            #     cnt+=1
            visited[du][dv]+=k




#각 말 별(index번호별) 바라보는 방향에 따른 d list
dir = [[], \
       [[(-1, 0)],[(0, 1)], [(1, 0)],[(0, -1)]],\
        [[(-1, 0), (1, 0)],[(0, -1), (0, 1)],[(1, 0), (-1, 0)],[(0, 1), (0, -1)]],\
       [[(-1, 0), (0, -1)],[(-1, 0), (0, 1)],[(1, 0), (0, -1)],[(1, 0), (0, 1)]],\
       [[(1, 0), (0, -1), (0, 1)],[(-1, 0), (1, 0), (0, 1)],[(-1, 0), (0, -1), (0, 1)], [(-1, 0), (1, 0), (0, -1)]],\
       [[(1, 0), (0, -1), (-1, 0), (0, 1)]]]
dir_range_lst = [-1, 4, 2, 4, 4, 1]

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]
chess_len = 0
lst = []
answer = n*m

#체스 말 리스트 받아두기
for i in range(n):
    for j in range(m):
        if arr[i][j]!=0 and arr[i][j]!=6:
            lst.append((i, j))
            chess_len += 1
        elif arr[i][j]==6:
            visited[i][j]=6

#체스 말이 보고 있을 방향 정하기 (dir_range_lst가 for문의 범위)
dfs(0)

print(answer)


