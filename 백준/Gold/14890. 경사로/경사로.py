"""
1500 문제읽기시작
1506 문제 이해 완 구상시작
1532 구현 및 디버깅 완료 / 코드트리 정답

디버깅 중 내려갔다가 올라가는 중에 이미 경사로 놓은 곳 처리 미흡해서 디버깅 시간 걸림



===================구상==========================
1. 행과 열 각각 고려하므로 행끼리 개수 세기 / 열끼리 개수 세기 각각 하기
2. 경사로는 visited에 체크 .
    그래서 1차이 나는 곳 이동할 때 낮은 쪽 자리에 visited 1인지 체크하여 통행여부 체크

3. 경사로깔기 : 왼쪽에서 오른쪽으로 탐색(행기준으로 살펴보자)
    탐색할 때 이전 값을 봐야하니까 1부터 시작
    - 수가 커지든 작아지든 그 차이가 2 이상이면 무조건 불가능
    - 수가 작아지는 경우
        그 순간부터 cnt 하기 cnt==L되면 시작지점부터 visited체크
        cnt<L 이고 다른 값 나오면 바로 FALSE 이므로 그 행은 cnt 안하기

    - 수가 커지는 경우
        그 지점부터 L만큼 뒤로가며 cnt세고 가능한지 보기
        가능하면 visited 체크하고 넘어가기
"""
def check_row(i):
    cnt= 1 #연속된 수 기록
    for j in range(1, N):
        if visited[i][j]:
            continue
        if arr[i][j-1]==arr[i][j]:
            cnt+=1
            continue
        if abs(arr[i][j-1]-arr[i][j]) >=2:
            #이 행은 경사로 놔도 통행 불가
            # print("2이상 차이나서 실패")
            return False

        #수가 커지는 경우
        if arr[i][j-1]<arr[i][j]:
            if cnt>=L: #지금까지 연속된 수가 L보다 컸다면 가능
                for k in range(L):
                    if visited[i][j-1-k]:
                        return False
            else:
                # print("수가 커지는 경우 실패 :  ",  j)
                # print(cnt)
                return False
        #수가 작아는 경우
        else:
            for k in range(L):
                #j부터 L개의 칸을 보기 (자리 있나 없나 + 같은 숫자인가)
                if j+k >=N or arr[i][j+k]!=arr[i][j]:
                    # print("수가 작아지는 경우 실패 :  ", j)

                    return False
                visited[i][j+k] = 1
        cnt = 1
    return True

N, L = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

answer = 0
visited = [[0]*N for _ in range(N)]
#행 개수 탐색(i행이 경사로 놓아서 통행 가능한지 체크)
for i in range(N):
    # print("행, ", i)

    if check_row(i):
        answer+=1
# print("answer : " , answer)
arr = list(zip(*arr))
visited = [[0]*N for _ in range(N)]

for i in range(N):
    # print("열, ", i)
    if check_row(i):
        answer += 1
print(answer)