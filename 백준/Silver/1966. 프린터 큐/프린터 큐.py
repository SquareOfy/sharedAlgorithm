from collections import deque

t = int(input())

for tc in range(t):
    n, m = map(int, input().split())
    lst = list(map(int, input().split()))
    arr = [[i, lst[i]] for i in range(n)]

    q = deque(arr)
    cnt = 0

    while 1 :
        now = q.popleft()

        flag = False
        for a in q:
            if a[1] > now[1]:
                q.append(now)
                flag = True
                break

        if not flag:
            cnt += 1
            if now[0] == m:
                break

    print(cnt)


