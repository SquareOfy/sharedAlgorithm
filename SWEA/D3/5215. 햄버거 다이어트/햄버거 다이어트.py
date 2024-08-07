t = int(input())

def dfs(level, like_score, calories):
    '''

    :param level: 현재 고려할 재료의 index
    :param like_score: 현재까지 조합한 재료의 맛 점수 합
    :param calories: 현재까지 조합한 재료의 칼로리 합
    :return: 마지막 재료까지 모두 고려한 이후, 현재까지 모은 맛의 점수로 갱신
    칼로리 합이 이미 기준을 넘어선 경우 return
    '''
    global answer
    if calories > l:
        return
    if level == n:
        answer = max(like_score, answer)
        return

    dfs(level+1, like_score+arr[level][0], calories+arr[level][1])
    dfs(level+1, like_score, calories)

for tc in range(1, t+1):
    n, l = map(int, input().split())
    arr = [list(map(int, input().split())) for i in range(n)]
    answer = 0
    dfs(0, 0, 0)
    print(f"#{tc} {answer}")
