import sys
sys.setrecursionlimit(60000)
def get_max(up, bottom):
    for k in range(6, 0, -1):
        if k==up or k==bottom:
            continue
        return k
def dfs(cnt, max_sum, bottom):
    global answer
    if cnt == n:
        answer = max(max_sum, answer)
        return
    #bottom으로 들어온 숫자가 나의 bottom이 될 것
    idx = -1 #난 어디를 bottom으로?
    for j in range(6):
        if arr[cnt][j]==bottom:
            idx = j
            break
    up = arr[cnt][trans_lst[idx]]
    side = get_max(up, bottom)
    dfs(cnt+1, max_sum+side, up)
trans_lst = [5, 3, 4, 1, 2, 0] #맞은편 숫자 찾을 때 idx짝꿍

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
answer = 0
#바닥 정하기
for i in range(6):
    bottom = arr[0][i]
    up = arr[0][trans_lst[i]]
    max_side = get_max(up, bottom)
    dfs(1, max_side, up)
print(answer)