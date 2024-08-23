from collections import deque
"""
1508 문제읽기 시작
1516 문제 이해 완 / 주석 구상 시작
1538 구현하고 디버깅,, 
~1545 내리는 위치 항상 도달 즉시 내리는 것 처리 안한 것 발견 . ! 시간초과..
1545~ 무한루프 가능성,, 테케 생각해보자. 종료 조건문 수정


visited : 0 ~ 2N-1칸에 로봇 있/없 확인
lst : 0~2N-1칸 내구도 관리
q : 벨트 위의 로봇들 넣어두기
up : 올리는 위치에 와 있는 칸의 idx /-1씩 줄어듬, mod 2N
down : 내리는 위치에 와 있는 칸의 idx/ -1씩 줄어듬, mod 2N

answer : 현재 단계 / 1부터 시작

while문 내에서 주어진 단계 차례대로 수행
    - 벨트 회전 ( up, down 조절)
        로봇 이동 (내구도, visited 체크)
    - 현재 올리는 위치의 내구도 visited 체크 후 로봇 올리기(내구도 -=1 visited체크)
    - 내구도 0 개수 확인 및 break
    - answer 더하기
"""

n, k = map(int, input().split())
lst = list(map(int, input().split()))
mod = 2*n
power = lst.count(0)
visited = [0] * (2*n)
up = 0
down = n-1
q = deque([])
answer = 1
while 1:
    up = (up-1)%mod
    down = (down-1)%mod

    size = len(q)
    for i in range(size):
        t = q.popleft()
        nt = (t+1)%mod
        if t==down:
            visited[t] = 0
            continue
        if not visited[nt] and lst[nt]>0:
            visited[t]=0
            lst[nt]-= 1
            if lst[nt]==0:
                power += 1
            if nt!= down:
                visited[nt] = 1

                q.append(nt)
        else:
            q.append(t)

    if not visited[up] and lst[up]>0:
        q.append(up)
        visited[up] = 1
        lst[up]-=1
        if lst[up]==0:
            power +=1
    if power >= k:
       break
    answer+=1

print(answer)
