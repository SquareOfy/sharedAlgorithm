n = int(input())
lst = list(map(int, input().split()))
answer = [lst[0]]

for i in range(1, n):
    if answer[-1] < lst[i]:
        answer.append(lst[i])
    else:
        left = 0
        right = len(answer)-1
        idx = -1

        while left <= right:
            mid = (left+right)//2
            if answer[mid] >= lst[i]:
                idx = mid
                right = mid -1
            else:
                left= mid+1
        answer[idx] = lst[i]
print(len(answer))