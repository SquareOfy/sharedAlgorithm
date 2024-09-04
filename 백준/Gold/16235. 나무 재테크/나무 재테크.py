"""
1641 문제 이해완 구상완 / 구현시작

"""
import heapq
N, M, K = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(N)]
trees = [[[] for _ in range(N)] for t in range(N)]
die_lst = [[[] for _ in range(N)] for t in range(N)]
ground = [[5]*N for _ in range(N)]
tmp = [[[] for _ in range(N)] for t in range(N)]
dir = (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)
for i in range(M):
    x, y, z = map(int, input().split())
    trees[x-1][y-1].append(z)
    # heapq.heappush(trees[x-1][y-1], z)


year = 0
while year < K:
    year += 1
    #봄 : 나이만큼 양분 먹기
    for i in range(N):
        for j in range(N):
            trees[i][j].sort()
            l = len(trees[i][j])
            for k in range(l):
                if ground[i][j] >= trees[i][j][k]:
                    ground[i][j] -= trees[i][j][k]
                    trees[i][j][k] += 1
                else:
                    for t in range(k, l):
                        ground[i][j] += trees[i][j][t]//2
                    trees[i][j][k:] = []
                    break


    # #나이 먹이기
    # for i in range(N):
    #     for j in range(N):
    #         for t in range(len(tmp[i][j])):
    #             heapq.heappush(trees[i][j], tmp[i][j].pop())

    #
    # #여름
    # for i in range(N):
    #     for j in range(N):
    #         for t in range(len(die_lst[i][j])):
    #             ground[i][j]+= die_lst[i][j].pop()//2

    #가을

    for i in range(N):
        for j in range(N):

            for t in trees[i][j]:
                if t%5 == 0:
                    for di, dj in dir:
                        du = i+di
                        dv = j+dj
                        if du<0 or dv<0 or du>=N or dv>=N:
                            continue
                        trees[du][dv].append(1)


    #겨울
    for i in range(N):
        for j in range(N):
            ground[i][j] += a[i][j]

ans = 0
for i in range(N):
    for j in range(N):
       ans+= len(trees[i][j])
print(ans)