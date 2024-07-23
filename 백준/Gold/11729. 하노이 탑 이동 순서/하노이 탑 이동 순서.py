k = int(input())


def get_stick(i, j):
    if 1 not in (i, j):
        return 1
    if 2 not in (i, j):
        return 2
    if 3 not in (i, j):
        return 3


def hanoi(i, start, end):

    if i == 0:
        return
    if i==1:
        print(start, end)
        # result.append([start, end])
        return
    hanoi(i-1, start, get_stick(start,end))
    print(start, end)
    hanoi(i-1, get_stick(start,end), end)



print(2**k-1)
hanoi(k, 1, 3)









