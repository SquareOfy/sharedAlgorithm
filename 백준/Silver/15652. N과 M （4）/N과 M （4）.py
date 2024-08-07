n, m = map(int, input().split())

def dfs(cnt, idx, selected):
    if cnt == m:
        print(*selected)
        return

    #연속으로 같은 수는 나올 수 있다! 하지만 더 커서는 안되므로 
    #다음 수 고를 때는 내 이후부터 보라고 i 전달
    #selected에 나 넣어서 전달
    for i in range(idx, n+1):
        dfs(cnt+1, i, selected+[i])

dfs(0, 1, [])