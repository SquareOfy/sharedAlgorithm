def check(mid):
    value = 0
    for money in lst:
        if money<=mid:
            value += money
        else:
            value += mid
    if value <= m:
        return True
    return False

n = int(input())
lst = list(map(int, input().split()))
m = int(input())
max_value = max(lst)
if sum(lst) <= m:
    print(max_value)
else:
    answer = 0
    st = 0
    ed = max(lst)

    while st <= ed:
        mid = (st+ed)//2
        if check(mid):
            answer = mid
            st = mid+1
        else:
            ed = mid-1
    print(answer)