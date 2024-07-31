from collections import deque
n, m = map(int, input().split())
dq = deque([i for i in range(1, n+1)])
lst = list(map(int, input().split()))
answer = 0

for i in lst:
    tmp_lst = list(dq)
    l = tmp_lst.index(i)

    if tmp_lst.index(i) < len(tmp_lst) - l:
        for k in range(l):
            dq.rotate(-1)
            answer += 1
    else:
        for k in range(len(tmp_lst)-l):
            dq.rotate()
            answer+=1
    dq.popleft()
print(answer)
