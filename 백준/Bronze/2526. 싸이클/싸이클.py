n, p = map(int, input().split())
visited = [0]*(p+1)
now = n
answer = 0


while 1:
    now *= n
    now %= p

    if visited[now] == 3:
        break
    visited[now] += 1

print(visited.count(3) if 3 in visited else 0)