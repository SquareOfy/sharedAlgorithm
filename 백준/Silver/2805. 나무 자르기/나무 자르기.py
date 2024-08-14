def check(mid):
    tree_sum = 0
    for h in lst:
        if h>mid:
            tree_sum += h-mid
    if tree_sum >= m:
        return True
    return False
n, m = map(int, input().split())
lst = list(map(int, input().split()))

st = 0
ed = max(lst)
answer = 0
while st<=ed:
    mid = (st+ed)//2
    if check(mid):
        answer = mid
        st = mid+1
    else:
        ed = mid-1
print(answer)