while 1:
    N, M = map(int, input().split())

    if N==0 and M==0:
        break

    points = [0]*10001
    for i in range(N):
        lst = list(map(int, input().split()))
        for m in lst:
            points[m] += 1

    rankings = list(enumerate(points))
    rankings.sort(key = lambda x:(-x[1], x[0]))
    max_points = rankings[0][1]
    idx = 0
    flag = False
    while idx < 10001:
        if not flag and rankings[idx][1] == max_points:
            idx+= 1
            continue
        if not flag and rankings[idx][1]<max_points:
            max_points = rankings[idx][1]
            flag = True

        elif flag and rankings[idx][1]<max_points:
            break
        print(rankings[idx][0], end=" ")
        idx += 1
    print()