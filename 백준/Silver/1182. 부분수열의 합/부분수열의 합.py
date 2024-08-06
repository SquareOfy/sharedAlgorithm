n, s = map(int, input().split())
lst = list(map(int, input().split()))

#level은 lst의 인덱스. 0~n-1까지 dfs로 돌며 
# 해당 값을 더한 경우와 안 더한 경우 각각 호출 
#cnt는 부분수열의 크기(한개도 안 고른 경우를 배제하기 위함)
#selected_sum에 이번 level에서 고른 수를 더해서 넘기기
def dfs(level, cnt, selected_sum):
    global answer
    if level == n:
        if cnt>0 and selected_sum == s:
            answer+=1
        return

    dfs(level + 1, cnt+1, selected_sum + lst[level]) #이번것 골랐을 때
    dfs(level + 1, cnt, selected_sum) #안골랐을 때

answer = 0
dfs(0, 0, 0)
print(answer)