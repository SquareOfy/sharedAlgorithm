n = int(input())
arr =list(map(int, input().split()))
visited = [0] * n
picked_list = [0] * n
max_answer = 0


def brute_force(depth):
    global max_answer
    if depth == n:
        # 식 계산 최댓값 구하기
        tmp = 0
        for i in range(1, n):
            tmp += abs(arr[picked_list[i-1]] - arr[picked_list[i]])
        max_answer = max(tmp, max_answer)

        return

    for i in range(n):
        if visited[i] != 0: continue
        picked_list[depth] = i
        visited[i] = 1
        brute_force(depth + 1)
        visited[i] = 0

brute_force(0)
print(max_answer)

