from collections import deque
n, k = map(int, input().split())



if n>=k:
    print(n-k)
    print(1)
else:
    answer_cnt = 0
    answer = 100002
    visited = [100002] * 100001
    visited[n] = 1
    q = deque([[n, 0]])
    while q:
        now = q.popleft()
        rank = now[1]
        if now[0] == k:
            if answer > rank:
                answer = rank
                answer_cnt = 1
            elif answer == rank:
                answer_cnt += 1
            continue

        jump = now[0]*2
        plus = now[0] +1
        minus = now[0]-1

        if jump <100001:
            if jump==k or visited[jump] >=rank+1:
                visited[jump] = rank+1
                q.append([jump, rank+1])
        if plus <100001:
            if plus == k or  visited[plus]>=rank+1:
                visited[plus] = rank+1
                q.append([plus, rank+1])
        if minus>=0:
            if minus == k or  visited[minus]>=rank+1:
                visited[minus] = rank+1
                q.append([minus, rank+1])
    print(answer)
    print(answer_cnt)