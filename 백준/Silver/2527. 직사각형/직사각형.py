for _ in range(4):
    rectangle = list(map(int, input().split()))

    x1, y1, p1, q1 = rectangle[0], rectangle[1], rectangle[2], rectangle[3]
    x2, y2, p2, q2 = rectangle[4], rectangle[5], rectangle[6], rectangle[7]


    w_sum = rectangle[2] - rectangle[0] + rectangle[6] - rectangle[4]
    h_sum = rectangle[3] - rectangle[1] + rectangle[7] - rectangle[5]


    same_point1 = (x1 == p2 and y1 == q2) or (p1 == x2 and q1 == y2)
    same_point2 = (p1 == x2 and y1 == q2) or (x1 == p2 and q1 == y2)

    if same_point1 or same_point2:
        print('c')

    elif max(abs(rectangle[6] - rectangle[0]), abs(rectangle[4] - rectangle[2])) > w_sum or max(
            abs(rectangle[7] - rectangle[1]), abs(rectangle[5] - rectangle[3])) > h_sum:
        print('d')
    elif x1 == p2 or p1 == x2 or y1 == q2 or q1 == y2:
        print('b')
    else:
        print('a')