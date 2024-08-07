# 퀸 놓을 자리를 각 행마다 어떤 열에 놓을지 정하기
# 퀸을 놓기 전에 대각선에 퀸이 있는지 확인하고 없다면 퀸 놓고
# 다음 행에 퀸 놓을 열 번호 구하러 다음 함수 호출하는 방식으로 구현할 것
# 이 때, 퀸을 놓을 수 있는지 확인하기 위해
# 2차원배열이 아닌 1차원 배열 활용해보자
# 어차피 순열로 퀸이 놓일 자리를 구하므로 가로, 세로는 겹칠 일이 없음
# 퀸이 놓인 행번호를 visited의 값으로 넣으면 굳이 2차원이 아니어도 체크 가능

#다른사람들 코드 참고해서 좌우대칭을 고려해서 answer +2 하는 식으로 코드 수정
n = int(input())
visited = [-2] * n
answer = 0


def dfs(cnt):
    global answer
    if cnt == n:
        answer += 2
        if n%2==1 and visited[n//2] == 0:
            answer -=1
        return
    for i in range(n):
        if visited[i] != -2:
            continue
        if cnt == 0 and (i < n // 2 or (n % 2 == 1 and i == n // 2)):
            visited[i] = cnt
            dfs(cnt + 1)
            visited[i] = -2
        elif cnt != 0:
            flag = True

            for k in range(1, max(n - 1 - i, i) + 1):
                # 우상체크
                if i + k < n and cnt + k < n and visited[i + k] == cnt + k:
                    flag = False
                    break
                # 좌하체크
                if i - k >= 0 and cnt - k >= 0 and visited[i - k] == cnt - k:
                    flag = False
                    break
                # 우하체크
                if i + k < n and cnt - k >= 0 and visited[i + k] == cnt - k:
                    flag = False
                    break
                # 좌상체크
                if i - k >= 0 and cnt + k < n and visited[i - k] == cnt + k:
                    flag = False
                    break
            if flag:
                visited[i] = cnt
                dfs(cnt + 1)
                visited[i] = -2


dfs(0)
print(answer)
