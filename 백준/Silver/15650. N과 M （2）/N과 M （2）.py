n,m = map(int, input().split())

def dfs(cnt, idx):
    if cnt==m:
        print(*selected)
        return

    #같은 수를 여러번 뽑지 않기 위해, 오름차순으로 수를 뽑기 위해
    #idx부터 n까지 cnt번째 수로 넣어보기
    for i in range(idx, n+1):
        selected[cnt] = i
        # 방금 넣은 수 다음부터 cnt+1번째에 넣어보기 위해 i+1 매개변수로 넘기기
        dfs(cnt+1, i+1)

selected = [0]*m
dfs(0,1)