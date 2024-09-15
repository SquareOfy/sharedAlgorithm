def dfs(level, score, now, flag, finished, selected, visited):
    global answer
    if level == 10:
        answer = max(answer, score)
        return

    num = arr[level]
    for i in range(4):
        if finished[i]:
            continue

        # 배열 복사 for dfs
        tmp_now = now[:]
        tmp_flag = flag[:]
        tmp_finished = finished[:]
        tmp_visited = [[] for _ in range(4)]
        for k in range(4):
            tmp_visited[k] = visited[k][:]

        # 다음 이동할 지점과 이전 flag 기억!!!!
        next = tmp_now[i] + num
        bf = tmp_flag[i]

        # 파란색 탄 적 없고 다음 이동할 칸이 파란색 화살표 따라가면
        # flag를 해당 화살표로 변경해준다
        if not flag[i]:
            if next > 0 and next % 5 == 0 and next // 5 < 4:
                tmp_flag[i] = next // 5

        # 이전 말 위치 해지하기(동시에 만나는 곳이라면 visited 일괄 관리)
        if tmp_now[i] == len_lst[tmp_flag[i]] - 1:
            for k in range(4):
                tmp_visited[k][len_lst[k] - 1] = 0
        elif tmp_flag[i] and tmp_now[i] >= flag_meet_timing[tmp_flag[i]]:
            go_after_25 = tmp_now[i] - flag_meet_timing[tmp_flag[i]]
            for k in range(1, 4):
                tmp_visited[k][flag_meet_timing[k]+go_after_25] = 0
        else:
            tmp_visited[bf][tmp_now[i]] = 0

        # 이동할 위치가 40을 넘어가면
        if next >= len_lst[tmp_flag[i]]:
            # 말 현재지점으로 옮기고 종료했다는 것 표시하고 다음 말 옮기러 가기
            tmp_now[i] = len_lst[tmp_flag[i]]
            tmp_finished[i] = 1
            dfs(level + 1, score, tmp_now, tmp_flag, tmp_finished, selected + [i], tmp_visited)
            continue

        # 말 next 위치로 옮길 수 있는지 체크
        # 파란색 따라가면 그 flag에서 본다
        if tmp_visited[tmp_flag[i]][next]:
            continue


        # 다음 칸이 파란선을 타면서 25 이후이면
        if next == len_lst[tmp_flag[i]] - 1:  # 40 일 때
            for k in range(4):
                tmp_visited[k][len_lst[k] - 1] = i + 1
        elif tmp_flag[i] and next >= flag_meet_timing[tmp_flag[i]]:
            go_after_25 = next-flag_meet_timing[tmp_flag[i]]
            for k in range(1, 4):
                st_point_by_flag = flag_meet_timing[k]
                tmp_visited[k][go_after_25+st_point_by_flag] = i + 1
            if next == len_lst[tmp_flag[i]] -1:
                visited[0][20] = i+1
        else:
            tmp_visited[tmp_flag[i]][next] = i + 1  # 파란색따라가면 파란색 쪽으로 체크해준다

        tmp_now[i] = next
        plus = score_arr[tmp_flag[i]][tmp_now[i]]
        dfs(level + 1, score + plus, tmp_now, tmp_flag, tmp_finished, selected + [i], tmp_visited)


score_arr = [
    [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0],
    [0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40, 0],
    [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40, 0],
    [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40, 0]

]

len_lst = [21, 13, 17, 23]
flag_meet_timing = [0, 9, 13, 19]
finished = [0] * 4
visited = [[0] * 24 for _ in range(4)]  # 0 출발점 끝점 len_lst[i]
flag = [0] * 4
now = [0] * 4
arr = list(map(int, input().split()))
answer = 0
dfs(0, 0, now, flag, finished, [], visited)
print(answer)