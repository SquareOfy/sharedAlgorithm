def dfs(level):
    global answer
    if level==n:
        con = 0
        for i in range(n):
            work = selected[i]>=3 #true면 감시 아니면 정보수집
            num = selected[i]%3
            same = i-1>=0 and selected[i-1]%3==selected[i]%3
            if work:
                if same:
                    con += watch[num]//2
                else:
                    con+= watch[num]

            else:
                if same:
                    con+= info[num]//2
                else:
                    con+=info[num]

        if con >= m:
            answer+=1
        return
    for i in range(6):
        selected[level] = i
        dfs(level+1)
n, m = map(int, input().split())

info = list(map(int, input().split()))
watch = list(map(int, input().split()))
answer = 0
selected = [0]*n
dfs(0)
print(answer)