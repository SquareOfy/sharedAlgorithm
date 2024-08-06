n, m = map(int, input().split())


def combination(cnt):
    #다 뽑았으면 출력 후 리턴
    if cnt == m:
        print(*selected)
        return

    # selected에 1부터 n까지 넣을 수 있으면 다 넣어보기
    # 이미 뽑은 수라면 continue하고 아니라면
    # selected에 넣고 cnt+1번째 수 뽑으러 가기 
    for i in range(1, n + 1):
        if visited[i]:
            continue
        selected[cnt] = i
        visited[i] = 1
        combination(cnt + 1)
        visited[i] = 0


selected = [0] * m
visited = [0]*(n+1) #selected에 사용됐는지 확인하는 방문체크배열
combination(0)
