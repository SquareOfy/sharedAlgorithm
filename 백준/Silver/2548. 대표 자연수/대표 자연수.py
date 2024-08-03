n = int(input())
lst = list(map(int, input().split()))
lst.sort()
right = n
left = 0
gap_min = sum(lst)
answer = 0
while left <= right:
    mid = (left + right)//2
    mid_value = lst[mid]
    gap_sum = 0
    for i in lst:
        gap_sum += abs(i-mid_value)
    if gap_sum <= gap_min:
        gap_min = gap_sum
        right = mid-1
        answer = mid_value
    else:
        left = mid+1

print(answer)