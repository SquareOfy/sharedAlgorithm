def dfs(cnt, idx, is_win):
    global flag
    if flag:
        return
    #6까지 다 시도했으면 !
    if cnt == 6:
        #win이면 win/lose 배열에 0 아닌 값 있는지 체크(있으면 flag 변경)
        if is_win:
            tmp = 0
            for k in range(6):
                if win[k] != 0 or lose[k]!=0:
                    tmp+=1
                    break
            #문제 없으면 tie 호출
            if tmp == 0:
                dfs(0, 0, 0)
        #tie이면 tie에 0아닌 값 있는지 체크 (있으면 flag변경)
        else:
            tmp = 0
            for k in range(6):
                if tie[k] != 0:
                    tmp+=1
                    break
            if tmp ==0:
                flag=True
        return
    if idx == 6:
        if is_win and win[cnt]!=0:
            return
        elif not is_win and lose[cnt]!=0:
            return
        dfs(cnt+1, 0, is_win)
    if is_win and (win[cnt]==0): #win 빼고 있고 현재 cnt에서 0이면 다음 애꺼 빼러 가
        dfs(cnt+1, 0, is_win)
    elif not is_win and (tie[cnt] ==0 or idx==6): #tie일 때도 마찬가지
        dfs(cnt+1, 0, is_win)

    for i in range(idx, 6):
        #win, lose를 빼는 dfs일 때
        if is_win:
            #뺄 lose값이 없거나, 나라면 넘어가기
            if lose[i]==0 or i==cnt:
                continue
            if win_visited[cnt][i]:
                continue
            #아니면 해당 lose에서 빼보기
            win[cnt] -= 1
            lose[i]-=1
            #다음 것 빼보러 가기
            win_visited[cnt][i] = 1
            win_visited[i][cnt] = 1
            dfs(cnt, i+1, is_win)
            lose[i]+=1
            win[cnt]+=1 #원위치
            win_visited[cnt][i] = 0
            win_visited[i][cnt] = 0
        else: #tie 빼는 dfs일 때
            if tie[i]==0 or i == cnt: #뺄 tie가 없거나, 자기 자신일 때 넘어가
                continue
            if tie_visited[cnt][i]:
                continue
            tie[cnt]-=1 #나 자신과 걔
            tie[i] -= 1 #빼봐
            tie_visited[cnt][i] = 1
            tie_visited[i][cnt] = 1
            dfs(cnt, i+1, is_win) #다음 빼기 하러 가
            tie[i]+=1 #원상복귀
            tie[cnt]+=1
            tie_visited[cnt][i] = 0
            tie_visited[i][cnt] = 0

arr = [list(map(int, input().split())) for _ in range(4)]
win_visited = [[0]*6 for _ in range(6)]
tie_visited = [[0]*6 for _ in range(6)]

for i in range(5):
    win_visited[i][i] = 1
    tie_visited[i][i] =1
for i in range(4):
    win = list(map(int, arr[i][::3]))
    lose = list(map(int, arr[i][2::3]))
    tie = list(map(int, arr[i][1::3]))
    flag = False

    #각 사람마다 승,패,무승부 합이 5가 아니면 불가하므로 dfs 실행 x
    for i in range(6):
        if win[i]+lose[i]+tie[i] != 5:
            break
    else:
        #모두의 시합 수가 5이고,
        #이긴횟수 == 진 횟수라면 dfs 해보기
        if sum(win)==sum(lose):
            dfs(0, 0, 1)
    if flag:
        print(1, end=" ")
    else:
        print(0, end=" ")

