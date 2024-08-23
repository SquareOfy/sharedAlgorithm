from collections import deque

"""
1430 문제읽기 시작
1437 열쇠로 코드 고쳐주기... 다른코드 ..
1442 간략 구상 완료 
1500 구현완료했으나 테케 안맞음
1506 q에 구름 이동 전 위치로 잘못 넣은 것 확인해서 고침




=========================================
좌 / 좌상 / 상 / 우상/ 우 / 우하 / 하 / 좌하  순
1. 초기 구름 q에 넣기
2. for문 m번 
    2-1. q에 있는 구름을 모두 꺼내서 d방향으로 s만큼 이동/ 이동완료 후 그 칸에 +1
        visited체크하기 / 범위 넘어가면 mod 처리
    2-2. visited 1인 곳 대각에 arr[r][c] 더해주기
    2-3. 전체 탐색=> arr[r][c]>=2 and not visited[r][c]이면
         구름에 추가
3. sum 구해서 출력
"""


n, m = map(int, input().split())

q = deque([(n-1, 0), (n-1, 1), (n-2, 0), (n-2, 1)])
q2 = deque([])
directions = (0,-1),(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)
diagonal = (-1, -1), (-1, 1), (1, -1), (1, 1)
arr = [list(map(int, input().split())) for i in range(n)]
for t in range(m):
    d, s = map(int, input().split())
    d-=1
    visited = [[0]*n for _ in range(n)]
    #구름 이동
    while q:
        cr, cc = q.popleft()
        nr, nc = cr+directions[d][0]*s, cc+directions[d][1]*s
        nr%=n
        nc%=n
        arr[nr][nc]+=1
        q2.append((nr, nc))
    #구름 주변 대각 증가
    while q2:
        cr, cc = q2.popleft()
        if visited[cr][cc]!=0:

            arr[cr][cc] += visited[cr][cc]-1

            continue
        value = arr[cr][cc]
        cnt = 0
        #대각 이동
        for di, dj in diagonal:
            nr = cr+di
            nc = cc+dj
            if nr<0 or nc <0 or nr>=n or nc>=n:
                continue
            if arr[nr][nc] != 0:
                cnt+=1
        visited[cr][cc] = cnt+1
        if cnt !=0:
            q2.append((cr, cc))

    for r in range(n):
        for c in range(n):
            if arr[r][c] >=2 and not visited[r][c]:
                q.append((r,c))
                arr[r][c] -= 2



answer = 0
for lst in arr:
    answer+=sum(lst)
print(answer)
