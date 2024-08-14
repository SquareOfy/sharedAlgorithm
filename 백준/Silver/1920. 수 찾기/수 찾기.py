n = int(input())
lst = list(map(int, input().split()))
m = int(input())
target = list(map(int, input().split()))
lst.sort()
for t in target:
    st = 0
    ed = n-1
    while st <= ed:
        mid = (st+ed)//2

        if lst[mid] == t:
            break
        if lst[mid] < t:
            st = mid+1
        else:
            ed = mid-1
    if lst[mid] == t:
        print(1)
    else:
        print(0)