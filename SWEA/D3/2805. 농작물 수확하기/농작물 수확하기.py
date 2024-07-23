t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = [list(map(int, list(input()))) for _ in range(n)]

    answer = 0
    for i in range(n):
        start = abs(n//2 - i)
        for j in range(start, start+abs(n-start*2)):
            answer += arr[i][j]

    print(f"#{tc} {answer}")

