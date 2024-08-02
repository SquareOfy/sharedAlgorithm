from collections import deque

n, k = map(int, input().split())
max_len = 100001

if n > k:
    print(n - k)
    print(1)
else:
    q = deque([n])
    time_visited = [0] * max_len
    cnt_visited = [0] * max_len
    time_visited[n] = 1
    cnt_visited[n] = 1

    while q:
        now = q.popleft()

        if now == k:
            continue

        for t in (now * 2, now + 1, now - 1):
            if 0 <= t < max_len:
                if not time_visited[t]:
                    q.append(t)
                    time_visited[t] = time_visited[now] + 1
                    cnt_visited[t] = cnt_visited[now]
                elif time_visited[t] == time_visited[now]+1:
                    cnt_visited[t] += cnt_visited[now]

    print(time_visited[k]-1)
    print(cnt_visited[k])
