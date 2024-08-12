def get_idx(start, end):
    if (start, end) in ((1, 3), (3, 1)):
        return 2
    if (start, end) in ((1, 2), (2, 1)):
        return 3
    if (start, end) in ((2, 3), (3, 2)):
        return 1


def hanoi(start, end, k):
    if k == 1:
        print(start, end)
        return
    mid = get_idx(start, end)
    hanoi(start, mid, k-1)
    hanoi(start, end, 1)
    hanoi(mid, end, k-1)


n = int(input())
print(2**n-1)
hanoi(1, 3, n)