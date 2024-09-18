"""
주사위 수 num
현재 칸 i
i+num>100이면 이동불가
i+num 이 사다리면 사다리 타고 이동
i+num 이 뱀이면 뱀 타고 이동

#사다리와 뱀 정보가 주어질 때 100까지 도착하기 위한 주사위 횟수의 최솟값은?

#bfs
100부터 출발해서 1,2,3,4,5,6칸으로 확장.
그 칸에서 사다리 있으면 이전 칸으로 / 뱀 있으면 이후 칸으로 이동해보며
1이 가장 먼저 나올 때의 rank가 답

"""
from collections import deque


def bfs():
    q = deque([(1, 0)])
    visited = [0] * 101
    visited[1] = 1
    while q:
        now, rank = q.popleft()
        if now == 100:
            return rank
        for i in range(1, 7):
            if now + i > 100:
                break
            next = now + i
            if visited[next]:
                continue
            while ladder[next] != 0 or snake[next] != 0:
                if ladder[next] != 0:
                    next = ladder[next]
                elif snake[next] != 0:
                    next = snake[next]
            q.append((next, rank + 1))
            visited[next] =1
    return -1


N, M = map(int, input().split())
ladder = [0] * 101
snake = [0] * 101
for i in range(N):
    a, b = map(int, input().split())
    ladder[a] = b  # a에서 온 사다리
for i in range(M):
    a, b = map(int, input().split())
    snake[a] = b  # a에서 온 뱀

answer = bfs()
print(answer)