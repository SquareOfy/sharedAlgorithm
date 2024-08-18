def dfs(cnt, energy):
    global answer
    # 2부터 n-2중 하나 고르기 ... 총 n-2개 고르기
    if cnt == n-2:
        answer = max(energy, answer)
        return
    for i in range(1, n-1):
        if lst[i] == 0:
            continue
        tmp = lst[i]
        lst[i]=0
        left = i-1
        while lst[left]==0:
            left -= 1
        right = i+1
        while lst[right]==0:
            right += 1
        dfs(cnt+1, energy+lst[left]*lst[right])
        lst[i] = tmp

n = int(input())
lst = list(map(int, input().split()))
answer = 0
dfs(0, 0)
print(answer)