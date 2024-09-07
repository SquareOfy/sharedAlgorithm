from collections import deque
n = int(input())
lst = list(map(int, input().split()))
answer = -1
q = deque([(0, 0)])
visited = [0]*n
visited[0] = 1


while q:
    i, rank = q.popleft()
    if i==n-1:
        answer = rank
        break
    for k in range(1, lst[i]+1):
        if i+k >=n:
            continue
        if not visited[i+k]:
            visited[i+k] = 1
            q.append((i+k, rank+1))
print(answer)