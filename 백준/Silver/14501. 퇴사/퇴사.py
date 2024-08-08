n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
answer = 0

#level : arr의 index
#money: 지금까지 돈

def dfs(level, money):
    global answer
    if level == n:
        answer = max(money, answer)
        return

    #이번에 본 index에서 수업 불가하면 다음 index 보기
    if level + arr[level][0] > n:
        dfs(level+1, money)
        return
    dfs(level+arr[level][0], money+arr[level][1])
    dfs(level+1, money)

dfs(0, 0)
print(answer)
