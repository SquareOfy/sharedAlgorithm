n, m = map(int, input().split())

lst = list(map(int, input().split()))

def calculate_tree(mid):
    result = 0

    for i in lst:
        if i>mid:
            result+= i-mid

    return result


left = 0
right = max(lst)
answer = right
while left < right:

    mid = (left+right)//2

    result = calculate_tree(mid)

    if result < m:
        right = mid

    else:
        left = mid + 1
        answer = mid


print(answer)

