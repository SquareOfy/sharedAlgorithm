def dfs(level, lst):
    if level==K:
        calculate(lst)
        return

    for i in range(K):
        if not visited[i]:
            visited[i] = 1
            dfs(level+1, lst+[i])
            visited[i] = 0

def calculate(lst):
    global answer
    tmp = [arr[t][:] for t in range(N)]

    for i in lst:
        r, c, s = order_lst[i]
        r -= 1
        c -= 1
        for k in range(1, s+1):
            sr = r-k
            sc = c-k
            tmp_value = tmp[sr][sc]
            l = 2*k
            for di, dj in (1, 0), (0, 1), (-1, 0), (0, -1):
                for t in range(l):
                    tmp[sr][sc] = tmp[sr+di][sc+dj]
                    sr+=di
                    sc+=dj
            tmp[r-k][c-k+1] = tmp_value
        #     print("==============세부 돌리기==================")
        #     print("lst : ", lst)
        #     for z in range(N):
        #         print(tmp[z])
        #     print("================================")
        # print("================================")
        # print("lst : ", lst)
        # for z in range(N):
        #     print(tmp[z])
        # print("================================")
    # print("================================")
    # print("lst : ", lst)
    # for z in range(N):
    #     print(tmp[z])
    # print("================================")
    # print()
    for v in range(N):
        answer = min(sum(tmp[v]), answer)

N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
answer = float('inf')
# for i in range(N):
#     answer = min(answer, sum(arr[i]))
order_lst = [list(map(int, input().split())) for _ in range(K)]

visited = [0]*K
dfs(0, [])
print(answer)