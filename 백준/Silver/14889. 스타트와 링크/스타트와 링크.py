import sys
input = sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

answer = 100 * n * n
visited = [0] * n
default_sum = 0
sum_lst = [0] * n
sum_lst2 = [0] *n




for i in range(n):
    sum_lst2[i] = sum(arr[i])
    for j in range(n):
        sum_lst[j] += arr[i][j]

default_sum = sum(sum_lst)


def pick_team(cnt, idx, other):
    global answer

    if cnt == n // 2:
        answer = min(answer, abs(other))
        return

    for i in range(idx, n):
        if visited[i]:
            continue

        visited[i] = 1
        pick_team(cnt + 1, i+1, other-sum_lst2[i]-sum_lst[i])
        visited[i] = 0


visited[0] = 1
selected = [0]
pick_team(1, 1, default_sum-sum_lst[0]-sum_lst2[0])
print(answer)
