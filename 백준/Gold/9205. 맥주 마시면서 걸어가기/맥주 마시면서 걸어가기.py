from collections import deque
t = int(input())

def dist(x,y, i, j):
    return abs(x-i) + abs(y-j)


for tc in range(t):
    n = int(input())
    si, sj = map(int, input().split())
    plst = [list(map(int, input().split())) for _ in range(n)]
    ei, ej = map(int, input().split())
    limit = 1000
    answer = "sad"
    if dist(si,sj, ei,ej) <= limit:
        print("happy")
        continue

    q = deque([[si, sj]])
    visited = [0]*n

    while q:
        now = q.popleft()
        r = now[0]
        c = now[1]
        if dist(r, c, ei, ej) <= limit:
            answer = "happy"
            break

        for i in range(n):
            pi = plst[i][0]
            pj = plst[i][1]
            if not visited[i] and dist(r, c, pi, pj)<=limit:
                q.append(plst[i])
                visited[i] = 1
    print(answer)