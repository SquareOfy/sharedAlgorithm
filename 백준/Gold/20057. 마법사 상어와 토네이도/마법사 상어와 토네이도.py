"""
총 풀이시간 : 53분
1400 문제 읽기 시작(21분)
        - 처음에 문제 보고 잘 이해가 안가서 당황함
        - 차분하게 한줄한줄 메모하고 읽음
        - 토네이도 회전할 때 모래 퍼지는 방향에 대한 구현 고민됨 ,,
        - 매번 방향을 좌표 바꾸기, - 바꾸기 하다가 실수가 잦을 거라 생각해서 룩업테이블 만들 생각함
1421 룩업테이블 구현 시작
        - 타이핑 하다가 실수하기 쉬운 케이스라 코드로 구현하기로 함
        - 실수를 가장 안할 수 있는 문제 속 그림을 타이핑으로 작성하고
        - 해당 dictionary를 회전하여 배열에 4방향에 대한 ditionary 저장
1429 대략적인 구현 주석 정리 및 구현 시작
        - 토네이도 구현 시, while 문 내에 for문 4개 쓰려다가
        - 코드 반복 시, 코드가 한 눈에 안들어와 자주 오타내고 실수하던 과거의 내가 생각나
        - 한번에 깔끔하게 짜보려고 노력함
        - 0,0 일 때 종료시키는 부분에서 약간 버벅임 => 인덱스 에러 많이 만남
            원인 : dir 배열에서 오타 발견
            조건을 while문이 시작되는 위치에 두는걸로 변경

1455 구현 완료했으나 일부 테케 안맞음
    - 수의 범위가 커질 수록 크게 안맞았음
    - 전반적인 로직 점검했으나 문제에서 시킨대로 잘 수행한듯 해 룩업테이블 의심하며 print 디버깅
    - 위쪽 2%가 누락된 것 발견하고 수정해서 해결


* 잘한 점
    - 평소 잘 사용하지 않던 dictionary를 활용해 봄 => 코드 리뷰의 효과 ..?
    - 룩업테이블을 적재적소에 잘 활용한 느낌
    - 문제 이해 어려웠으나 차분하게 한줄한줄 음미하며 읽은 것..
* 못한 점
    - 오 !! 타 !!!!!!!!!!!!!!!1

"""


d_dict = [{(-2, 0): 2, (-1, -1): 10, (-1, 0): 7, (-1, 1): 1, (0, -2): 5, (1, -1): 10, (1, 0): 7, (1, 1): 1, (2, 0): 2},\
          {(0, -2): 2, (1, -1): 10, (0, -1): 7, (-1, -1): 1, (2, 0): 5, (1, 1): 10, (0, 1): 7, (-1, 1): 1, (0, 2): 2}, \
          {(2, 0): 2, (1, 1): 10, (1, 0): 7, (1, -1): 1, (0, 2): 5, (-1, 1): 10, (-1, 0): 7, (-1, -1): 1, (-2, 0): 2},\
          {(0, 2): 2, (-1, 1): 10, (0, 1): 7, (1, 1): 1, (-2, 0): 5, (-1, -1): 10, (0, -1): 7, (1, -1): 1, (0, -2): 2}]

dir = (0, -1), (1, 0), (0, 1), (-1, 0)
answer = 0

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

sr, sc = n // 2, n//2
l = 1
cnt = 0
d_idx = 0
while 1:
    if sr == 0 and sc == 0:
        break
    # 현재 방향으로 l만큼 토네이도 및 모래 이동하고
    # l만큼을 두번 갔다면! l+1시키기
    # 방향도 매번 회전하기
    di, dj = dir[d_idx]
    for i in range(l):
        # 토네이도 이동
        sr += di
        sc += dj
        sand = arr[sr][sc]
        # sr, sc에 있는 모래를 여기를 기준으로 이동
        for k, v in d_dict[d_idx].items():
            du = sr + k[0]
            dv = sc + k[1]
            spread_sand = (sand * v//100)
            arr[sr][sc] -= spread_sand
            if du < 0 or dv < 0 or du >= n or dv >= n:
                answer += spread_sand
                continue
            arr[sr + k[0]][sc + k[1]] += spread_sand
        # 모래 다 옮기고 나서 alpha 칸으로 남은 모래 전부 옮기기
        du = sr + dir[d_idx][0]
        dv = sc + dir[d_idx][1]
        if du < 0 or dv < 0 or du >= n or dv >= n:
            answer += arr[sr][sc]
        else:
            arr[du][dv] += arr[sr][sc]
        arr[sr][sc] = 0

        if sr == 0 and sc == 0:
            break
    cnt += 1
    if cnt == 2:
        l += 1
        cnt = 0
    d_idx = (d_idx + 1) % 4
print(answer)
