"""
문제읽기 3시 16분 ~ 20분
구상 20분 ~23분
구현시작 23분 ~32분 구현 완료

엉망진창 테케 결과로 디버깅 시작
33분 ~
answer 더해지는 부분부터 체크해봐야겠다
arr 값 잘못 이해했음 발견 ... 49분;;
arr 조건과 로봇 청소기 초기위치의 청소상태 헷갈려서 디버깅,, 54분 풀이 종료


==================================구상 ===========================
인덱스 0부터 시작
모두 청소 안된상태 ( visited 0으로 )
현재 칸 청소
현재 칸에서 사방 탐색해서 청소되지 않은 빈칸 여부 체크하기
빈칸 없다?
    바라보는 방향(d) 유지한체 후진하고 다시 사방탐색 반복
    벽이면 작동 멈추기(break)

빈칸 있다 ? 반시계 회전 (direction : 상 좌 하 우 로 만들고 +1 module)
앞에 빈칸이면 전진 아니면 회전
"""
def need_clean():
    for di, dj in directions:
        du = r+di
        dv = c+dj
        if obb(du, dv):
            return False
        if arr[du][dv] == 0:
            return True
    return False
def obb(du, dv):
    if du < 0 or dv < 0 or du >= n or dv >= m:
        return True
    return False
#input 받기
n, m = map(int, input().split())
r, c, d = map(int, input().split())

#d : 0 - 북(상)/ 1 - 동(우) /2- 남(하)  / 3(좌)
#arr배열 입력받기 => visited로 함께 활용할 것
arr = [list(map(int, input().split())) for _ in range(n)]
#direction 상우하좌로 준비 반시계 회전하려면 +3 mod
directions = (-1, 0), (0, 1),  (1, 0),(0, -1)
answer = 0
#while 문
while 1:
    if arr[r][c] == 0:
        arr[r][c] = 2
        answer+=1

    #현재칸 청소
    #사방탐색 청소된칸 여부 확인 (함수화)
    result = need_clean()
    #없으면 후진 후 continue
    if not result:
        du = r- directions[d][0]
        dv = c- directions[d][1]
        if obb(du, dv) or arr[du][dv]==1:
            break
        r = du
        c = dv
        continue

    #있으면 반시계회전 for문.
    #청소안된 곳이면 전진 후 break

    for i in range(4):
        d = (d + 3) % 4
        du = r+ directions[d][0]
        dv = c+ directions[d][1]
        if obb(du, dv) or arr[du][dv] == 1:
            continue
        #전진 후 청소
        if arr[du][dv] == 0:
            r = du
            c = dv
            break


print(answer)