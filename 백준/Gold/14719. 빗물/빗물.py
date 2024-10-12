H, W = map(int, input().split())
lst = list(map(int, input().split()))

answer = 0
stk = [lst[0]]
last_h = 0
for i in range(1, W-1):
    left = max(lst[:i])
    right = max(lst[i+1:])

    answer += max(0, min(left, right) - lst[i])
print(answer)