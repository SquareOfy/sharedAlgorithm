def dfs(level, idx, s):
    global answer
    if level==3:
        #answer 갱신
        tmp = 1
        for i in range(idx-1, n):
            tmp*=lst[i]

        answer = max(answer, s+tmp)
        return
    tmp = 1
    for i in range(idx, n):
        tmp*=lst[i-1]
        dfs(level+1, i+1, s+tmp)

n = int(input())
lst = list(map(int, input().split()))
answer =0

#4개의 그룹의 끝나는 지점 고르기 nC3
dfs(0, 1, 0)

print(answer)