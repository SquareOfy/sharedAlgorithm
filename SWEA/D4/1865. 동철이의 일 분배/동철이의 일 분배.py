t = int(input())

def set_staff(cnt, p):
    global answer
    if p<answer:
        return
    if cnt == n:
        answer = max(answer, p)
        return

    for i in range(n):
        if visited[i]:
            continue
        if arr[cnt][i] ==0:
            continue
        visited[i] = 1
        set_staff(cnt+1, p*(arr[cnt][i]/100))
        visited[i] = 0

for tc in range(1, t+1):
    n = int(input())

    arr = [list(map(int, input().split())) for _ in range(n)]
    answer = 0
    visited= [0] * n
    set_staff(0, 1)
    print(f"#{tc} {answer*100:0.6f}")
