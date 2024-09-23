from collections import deque

def bfs(rr, rc, br, bc):
    global answer
    q = deque([(rr, rc, br, bc, 1)])
    visit_dict[(rr, rc, br, bc)] = 1

    while q:
        crr, crc, cbr, cbc, rank = q.popleft()
        for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
            nbr, nbc = move(cbr, cbc, di, dj)
            if arr[nbr][nbc] == 'O':
                continue
            nrr, nrc = move(crr, crc, di, dj)
            if arr[nrr][nrc] == 'O':
                answer = min(rank, answer)
                break
            if nbr==nrr and nbc == nrc:
                if di == -1 or dj ==-1:
                    if cbr<crr or cbc<crc:
                        nrr -= di
                        nrc -= dj
                    else:
                        nbr -= di
                        nbc -= dj
                else:
                    if cbr<crr or cbc<crc:
                        nbr-=di
                        nbc-=dj
                    else:
                        nrr-=di
                        nrc-=dj
            next = (nrr, nrc, nbr, nbc)

            if visit_dict.get(next, -1) == -1:
                q.append((nrr, nrc, nbr, nbc, rank+1))
                visit_dict[next] = rank


def move(r, c, di, dj):
    while 0<r<N-1 and 0<c<M-1 and arr[r][c] == '.':
        r+=di
        c+=dj
        if arr[r][c] == 'O':
            return r, c
    if arr[r][c]=='#':
        r-=di
        c-=dj
    return r, c

N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]
rr, rc, br, bc = -1, -1, -1, -1
for i in range(N):
    for j in range(M):
        if arr[i][j] == 'B':
            arr[i][j] = '.'
            br, bc = i, j
        elif arr[i][j] == 'R':
            arr[i][j] = '.'
            rr, rc = i, j
# visited = [[[0]*4 for _ in range(M)] for _ in range(N)]
inf = (N-1)**2*(M-1)**2
answer = inf
visit_dict = {}
visit_dict[rr, rc, br, bc] = 0
bfs(rr, rc, br, bc)

print(answer if answer!= inf else -1 )