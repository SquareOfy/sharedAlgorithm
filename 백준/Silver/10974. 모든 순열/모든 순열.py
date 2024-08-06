n = int(input())

def dfs(cnt):
    if cnt == n:
        print(*selected)
        return
    #현재 selected에 사용한 적 없는 수만 현재 cnt번째에 넣어보기
    for i in range(1, n+1):
        if visited[i]:
            continue
        visited[i] = 1 #방문체크
        selected[cnt] = i
        dfs(cnt+1)
        visited[i] = 0 #넣어보는 dfs가 끝났으니 방문체크 해제

selected = [0]*n
visited = [0]*(n+1)
dfs(0)