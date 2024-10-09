from collections import deque


def oob(i, j):
    return i<0 or j<0 or i>=N or j>=M
def bfs():
    q = deque([(0, 0, 1, 1, 0)]) #r, c, rank, 낮, 부순 횟수
    visited[0][0][0] = 1

    while q:
        r, c, rank, flag, cnt = q.popleft()

        if r==N-1 and c==M-1:
            return rank
        for di, dj in DIR:
            du, dv = r+di, c+dj
            if oob(du, dv):
                continue
            if visited[du][dv][cnt]:
                continue
            if arr[du][dv]==1:
                if not flag and cnt<K: #낮이면 stay
                    q.append((r, c, rank+1, not flag, cnt))
                elif flag and cnt<K:
                    q.append((du, dv, rank+1, not flag, cnt+1))
                    visited[du][dv][cnt] = 1
            elif arr[du][dv] ==0:
                q.append((du, dv, rank+1, not flag, cnt))
                visited[du][dv][cnt] = 1
    return -1

N, M, K = map(int, input().split())
arr = [list(map(int, list(input()))) for _ in range(N)]
visited = [[[0]*(K+1) for _ in range(M)] for _ in range(N)]
DIR = (-1, 0), (1, 0), (0, -1), (0, 1)

answer = bfs()
print(answer)