"""
풀이시간 1시간 20분
실행시간
1416 문제읽기 시작 + 손설계
    기준이나 절차 복사해와서 필요한 부분만 남기는 정리했음
    각 절차별로 어떤 방식으로 구현할지 손으로 설계 + 슈더코드 작성
1419 구현할 부분 주석으로 정리해놓기
    이 과정에서 구현 계획 관련 설명 + 주의사항도 적어두고 해당 파트 문제도 다시 읽어봄

1439 구현시작

1506 중력이동 구현 후 틀려서 print+디버거 활용한 디버깅
    -1일 때는 끌어내리지 않도록 추가처리
    nr 의 초기값+ 선언 위치 문제 발견해서 수정 ! (nr은 끌어내릴 숫자의 위치 가리키는 변수)

1521 디버깅
    점수가 왜 다르지?
    블록별 개수 때문인가해서 그 부분 수정해봄 : 아니었음
    점수 얼마나 추가되는지 print찍어보며 문제 탐색
    sort 조건 다시 살펴봄 무지개 블록개수 누락 발견 => 수정
    무지개블록은 여러블록에 재사용될 수 있음 발견 => 수정

1536 정답

피드백
- 잘한점
    전반적으로 주석을 적을 수 있을 정도로 설계하고 들어감

- 아쉬운점
    무지개블록 놓침..(문제 내용)
    그러다보니 코드에 비효율적인 부분 생김 -> 개선해보자
    행 열을 위, 왼쪽부터 탐색하면 기준 블록은 굳이 정렬하지 않아도 처음 그 i, j가 기준블록임 ;



"""
from collections import deque
def set_block():
    #같은 블록인 기준
    #     - 상하좌우 연결
    #     - 일반블록&무지개블록으로만
    #     - 무조건 일반블록 하나 이상 포함
    #     - 같은 색의 일반블록
    # 블록 그룹의 기준 블록은 무지개 블록이 아닌 블록 중에서 행의 번호가 가장 작은 블록, 그러한 블록이 여러개면 열의 번호가 가장 작은 블록이다.
    # 기준블록은 정렬해서 찾기
    visited = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            if arr[i][j]>=1:
                lst = bfs(i, j, arr[i][j], visited)
                if len(lst)<2:
                    continue
                blocks.append(((i,j), lst)) # 0 : 기준 블록 좌표, 1:블록목록

def clean_rainbow(clean_lst, visited):
    for i, j in clean_lst:
        visited[i][j] = 0


def oob(i, j):
    return i>=n or i<0 or j>=n or j<0


def bfs(r, c, color, visited):
    visited[r][c] = 1
    q = deque([(r, c)])
    lst = []
    clean_lst = []

    while q:
        cr, cc = q.popleft()
        lst.append((cr, cc))
        for di, dj in dir:
            du = cr+di
            dv = cc+dj
            if oob(du, dv) or visited[du][dv]:
                continue
            if arr[du][dv] == -1:
                continue
            if arr[du][dv] != 0 and arr[du][dv] !=color:
                continue
            visited[du][dv] = 1
            q.append((du, dv))
            if arr[du][dv] == 0:
                clean_lst.append((du,dv))

    clean_rainbow(clean_lst, visited)
    return lst




# #격자 중력 작용 함수 만들기
def gravity():
    # 검은색 블록을 제외한 모든 블록이 행의 번호가 큰 칸으로 이동
    # (-1 제외하고 아래로 끌어내리기)

    for c in range(n):
        nr = n - 1
        r = n-1
        while r>0:
            if arr[r][c] !=-2:
                r-=1
                continue

            nr = min(r-1, nr)
            while nr>=0 and arr[nr][c]==-2:
                nr -=1


            if arr[nr][c]!=-1 and nr >=0:
                arr[r][c] = arr[nr][c]
                arr[nr][c] = -2

            r-= 1

def rotate_arr():
    return list(map(list, zip(*arr[::-1])))

def find_rainbow(lst):
    result = 0
    for i, j in lst:
        if arr[i][j] == 0:
            result+=1
    return result
#입력받기
dir = (-1, 0), (0, 1), (1, 0), (0, -1)
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

score = 0
while 1:

    #block setting 한다
    blocks = []
    set_block()
    if not blocks:
        break
    # print(blocks)
    #블록 세팅 검증 완료


    # 1. 크기가 가장 큰 블록 그룹을 찾는다.
    blocks.sort(reverse=True, key = lambda x : (len(x[1]),find_rainbow(x[1]), x[0][0], x[0][1]))
    big_block = blocks[0][1]

    # 2. 1에서 찾은 블록 그룹의 모든 블록을 제거. 점수 += 블록수**2
    score += len(big_block)**2
    for y, x in big_block:
        arr[y][x] = -2


    # 3. 격자에 중력이 작용
    gravity()

    arr = list(map(list, zip(*arr)))[::-1]

    gravity()

print(score)



