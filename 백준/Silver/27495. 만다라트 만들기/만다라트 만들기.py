n = 9
arr = [list(input().split()) for _ in range(n)]
directions = ((-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1))

cnt = 1
mid_lst = []
for d in directions:
    du = n // 2 + d[0]
    dv = n // 2 + d[1]
    # print(f"#{cnt}. {arr[du][dv]}")
    mid_lst.append([arr[du][dv], du, dv, d])

mid_lst.sort()
for lst in mid_lst:
    print(f"#{cnt}. {arr[lst[1]][lst[2]]}")
    details = []
    du = lst[1] + lst[3][0] * 2
    dv = lst[2] + lst[3][1] * 2
    for d2 in directions:
        dr = du + d2[0]
        dc = dv + d2[1]
        details.append(arr[dr][dc])
        # print(f"#{cnt}-{idx}. {arr[dr][dc]}")
    details.sort()
    idx = 1
    for d in details:
        print(f"#{cnt}-{idx}. {d}")
        idx+=1
    cnt += 1
