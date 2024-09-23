from collections import deque


def is_connect(c1, c2):
    sr, sc = c1
    er, ec = c2
    q = deque([(sr, sc, 0)])
    visited = [[0] * N for _ in range(N)]

    visited[sr][sc] = 1
    while q:
        cr, cc, is_road = q.popleft()

        # print(cr, cc)
        if cr == er and cc == ec:
            return True
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            du = cr + di
            dv = cc + dj
            if du < 0 or dv < 0 or du >= N or dv >= N or visited[du][dv]:
                continue
            if road.get((cr,cc), []) and (du, dv) in road[(cr, cc)]:
                continue
            visited[du][dv] = 1
            q.append((du, dv, is_road))
    return False



def change(i):
    return int(i) - 1


N, K, R = map(int, input().split())

road = {}
for i in range(R):
    sr, sc, er, ec = map(change, input().split())
    lst1 = road.get((sr, sc), [])
    lst1.append((er, ec))
    road[(sr, sc)] = lst1
    lst2 = road.get((er, ec), [])
    lst2.append((sr, sc))
    road[(er, ec)] = lst2

cow = [list(map(change, input().split())) for _ in range(K)]
answer = 0

for i in range(K):
    for j in range(i + 1, K):
        if not is_connect(cow[i], cow[j]):
            answer += 1


print(answer)