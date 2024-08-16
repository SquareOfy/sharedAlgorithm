"""
어떻게 풀까 ..
1부터 12 중 x인 빈칸에 넣을 것.
넣는 와중에 가지치기 필수
따라서 6줄의 sum을 저장하는 index를 매번 확인해야하므로,
숫자 고를 때마다 sum도 조정해야 함.

blank_lst에 0~11까지 자리 만들어 놓고, 각 순번에 해당하는 행열 좌표 넣어두기
알파벳 별로 사용했는지 여부를 판단할 visited배열 관리하기
몇개의 숫자를 더했는지를 저장할 sum_cnt_lst
dfs(cnt)
- blank_lst[cnt]에 0~11 중 가능한 알파벳 넣어보는 함수 for i in range(0, 12)
- blank_lst 좌표에 'x'가 아니면  cnt+1호출하고 return.
- arr배열에 blank_lst에 적힌 좌표에 그 알파벳 넣고 빼기 반복
- sum_cnt_lst에 어디어디 sum을 더했는지 카운트 +
- sum_idx_lst(n번째 blank가 영향을 끼치는 sum idx 저장한 배열)
- sum_idx_lst에 따라 sum_lst 더하기

* 가지치기
sum_cnt_lst[i] < 4 and sum_lst[i] >=26 일때
sum_cnt_lst[i] == 4 and sum_lst[i] != 26일때

"""
def dfs(cnt):
    global flag, answer
    if flag:
        return
    if cnt == 12:
        for j in range(6):
            if sum_lst[j]!=26 or sum_cnt_lst[j]!=4:
                return
        for k in range(n):
            print(*arr[k], sep='')
        flag = True
        return
    r, c = blank_lst[cnt]

    if arr[r][c] != 'x':
        dfs(cnt+1)
        return
    #가지치기
    for j in range(6):
        if sum_cnt_lst[j] <4 and sum_lst[j] >=26:
            return
        if sum_cnt_lst[j] ==4 and sum_lst[j]!=26:
            # print("여기서 return")
            return

    for i in range(1,13):
        #이 알파벳 사용했으면 넘어가기
        if visited[i]:
            continue
        arr[r][c] = chr(i+a)
        d = sum_idx_lst[cnt]
        sum_cnt_lst[d[0]] += 1
        sum_cnt_lst[d[1]] += 1
        sum_lst[d[0]] += i
        sum_lst[d[1]] += i
        visited[i]=1

        dfs(cnt+1)

        visited[i]=0
        sum_cnt_lst[d[0]] -= 1
        sum_cnt_lst[d[1]] -= 1
        sum_lst[d[0]] -= i
        sum_lst[d[1]] -= i
        arr[r][c] = 'x'







n, m = 5, 9
arr = [list(input()) for _ in range(n)]
answer = [[] for _ in range(m)]


visited = [0] * 13  # A부터 L이 인덱스 번호
sum_idx_lst = [(0, 1), (2, 3), (2, 0), (2, 1), (2, 4), (0, 3), (1, 4), (0, 5), (3, 5), (4, 5), (1, 5), (3, 4)]
sum_cnt_lst = [0]*6
sum_lst = [0]*6
blank_lst = [(0, 4), (1, 1), (1, 3), (1, 5), (1, 7), (2, 2), (2, 6), (3, 1), (3, 3), (3, 5), (3, 7), (4, 4)]
flag = False

a = ord('A')-1
idx = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] != 'x' and arr[i][j] != '.':
            visited[ord(arr[i][j]) -a] = 1
            d = sum_idx_lst[idx]
            sum_lst[d[0]] += ord(arr[i][j]) -a
            sum_lst[d[1]] += ord(arr[i][j]) -a
            sum_cnt_lst[d[0]] += 1
            sum_cnt_lst[d[1]] += 1
            idx+=1
        elif arr[i][j] == 'x':
            idx+=1

dfs(0)