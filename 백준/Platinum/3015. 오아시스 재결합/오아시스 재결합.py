import sys
input = sys.stdin.readline
n = int(input())
lst = [int(input()) for _ in range(n)]
left = [[lst[0],1]]

answer = [0] * n

for i in range(1 , n):
    if left and left[-1][0] > lst[i]:
        answer[i] += 1
        left.append([lst[i], 1])
    elif left and left[-1][0] <= lst[i]:
        cnt = 0

        while left and left[-1][0] < lst[i]:
            cnt += left[-1][1]
            num = left.pop()


        if not left:
            cnt -=1
        answer[i] += cnt + 1
        if left and left[-1][0] == lst[i]:
            answer[i] += left[-1][1]
            if len(left) > 1:
                answer[i] += 1
            answer[i] -= 1
            left[-1][1] += 1
        else:
            left.append([lst[i], 1])


print(sum(answer))