"""뒤집어엎기"""
from collections import deque

def bfs(i, j):
    q = deque([(i,j)])
    v = arr[i][j]
    visited[i][j] = 1
    lst = []
    while q:
        r, c = q.popleft()
        lst.append((r,c))
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = r+di
            dv = c+dj
            if dv == -1:
                dv = M-1
            elif dv==M:
                dv = 0
            if du<0 or du>=N:
                continue
            if visited[du][dv]:
                continue
            if arr[du][dv] == v:
                visited[du][dv] = 1
                q.append((du,dv))
    return lst
N, M, T = map(int, input().split())
arr = [deque(list(map(int, input().split()))) for _ in range(N)]
# q = deque([0, 0, 1]) #rotate >0 시계방향 <0 반시계방향

for t in range(T):
    visited = [[0]*M for _ in range(N)]
    x, d, k = map(int, input().split())
    if d == 1:
        k *= -1
    for i in range(x-1, N, x):
        arr[i].rotate(k)

    change = False
    #인접 동일 숫자 지우기
    for i in range(N):
        for j in range(M):
            v = arr[i][j]
            if v==0:
                continue
            lst = bfs(i, j)
            # print(lst)
            if len(lst)==1:
                continue
            for r, c in lst:
                arr[r][c] = 0
                change = True
            # flag = False
            # #안쪽 원
            # if i-1>=0 and arr[i-1][j] == v:
            #     arr[i-1][j] = 0
            #     flag = True
            # if i+1<N and arr[i+1][j] == v:
            #     arr[i+1][j] = 0
            #     flag = True
            # if arr[i][(j+(M-1))%M] == v:
            #     arr[i][(j+(M-1))%M] = 0
            #     flag = True
            # if arr[i][(j+1)%M] == v:
            #     arr[i][(j + 1) % M] = 0
            #     flag= True
            # if flag:
            #     arr[i][j] = 0
            #     change = True
    # print("지운 후 ")
    # for k in range(N):
        # print(arr[k])
    # print("")
    #지워진 적 없으면 평균내기
    if not change:
        # print("지운 적 없음")
        sum_num = 0
        cnt = 0
        for i in range(N):
            for j in range(M):
                if arr[i][j]:
                    sum_num+= arr[i][j]
                    cnt+=1
        if cnt!=0:
            mean = sum_num / cnt
            # print(mean)
            for r in range(N):
                for c in range(M):
                    if arr[r][c]==0:
                        continue
                    if arr[r][c]>mean:
                        arr[r][c]-=1
                    elif arr[r][c]<mean:
                        arr[r][c]+=1

s = 0
for i in range(N):
    s += sum(arr[i])
print(s)