n = int(input())
#각 row에 퀸을 놓은 열번호 사용 여부
used_queen = [0]*n

#퀸 놓을 때마다 공격 범위 체크하여, 다음 퀸 놓을 때
#놓을 수 있는지 확인하기 위한 배열
visited = [[0]*n for _ in range(n)]
answer = 0

def is_possible(r, c):
    #가로, 세로 x로 바꾸기
    for i in range(n):
        if visited[r][i]==2 or visited[i][c]==2:
            return False

    for d in (-1, -1), (1, 1), (-1, 1), (1, -1):
        du = r+d[0]
        dv = c+d[1]
        while 0<=du<n and 0<=dv<n:
            if visited[du][dv]:
                return False
            du += d[0]
            dv += d[1]
    return True


def dfs(cnt):
    global answer
    if cnt == n:
        answer+=1
        return

    for i in range(n):#열 번호
        if used_queen[i]:
            continue

        #(cnt, i)에 퀸을 놓을 때 공격범위인
        #가로, 세로, 좌대각 우대각에 visited가 1인 지점 있는지 체크
        #가로와 세로는 당연히 없을 것이므로 대각만 체크해도 됨
        if is_possible(cnt, i):
            #visited 1인 곳 없으면 퀸 놓고 used[i]체크하고 다음 함수 호출
            used_queen[i] = 1
            visited[cnt][i] = 1
            dfs(cnt+1)
            # 함수 종료 후 visited원상복구하기 used[i]도
            used_queen[i] = 0
            visited[cnt][i] = 0

        else:
            # 있으면 continue
            continue


dfs(0)
print(answer)

