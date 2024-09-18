def dfs(level, idx, song_cnt, visited):
    global answer, song_mx
    if song_cnt>song_mx:
        song_mx = song_cnt
        answer = level
    if song_cnt==song_mx and song_mx!=0:
        if level<answer:
            answer = level
            return

    if song_cnt == M:
        answer = min(level, answer)
        return

    for i in range(idx, N):
        new_cnt = 0
        tmp_visited = visited[:]
        for s in range(M):
            if lst[i][s]=='Y' and not visited[s]:
                tmp_visited[s] = 1
                new_cnt+=1


        dfs(level+1, i+1, song_cnt+new_cnt, tmp_visited)


N, M = map(int, input().split())
lst = []

for i in range(N):
    name, song = input().split()
    lst.append(song)

answer = N+1
song_mx = 0
visited = [0]*M
dfs(0, 0, 0, visited)
print(answer if song_mx>0 else -1)