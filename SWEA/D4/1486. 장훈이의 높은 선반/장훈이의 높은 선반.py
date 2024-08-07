t = int(input())

def dfs(level, selected_sum):
    global answer
    # 마지막 사람까지 뽑을지 말지 결정 다 했다면
    # 지금까지 쌓은 탑의 높이와 b의 차이 값을 활용해
    # answer min으로 갱신하기
    if level>=n:
        if selected_sum >=b:
            answer = min(answer, selected_sum-b)
        return

    #이번 레벨(이번 사람)의 값을 뽑을 때
    # sum매개변수에 값 더해서 다음 사람 뽑을지 정하러 가기!
    dfs(level + 1, selected_sum + lst[level])
    #안뽑을 때
    dfs(level + 1, selected_sum)


for tc in range(1, t+1):
    n, b = map(int, input().split())

    lst = list(map(int, input().split()))
    #최댓값(탑의 최대높이 - b가 차이)으로 초기 설정
    answer = sum(lst)-b
    dfs(0, 0)
    print(f"#{tc} {answer}")