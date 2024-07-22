

for tc in range(1, 11):
    n = int(input())

    arr = [list(map(int, input().split())) for _ in range(100)]


    #위 n극 아래 s 극
    answer = 0
    for c in range(100):
        red = False

        #down
        for r in range(100):
            if arr[r][c] == 1:
                red = True
            elif arr[r][c] == 2:
                if red:
                    answer += 1
                    red = False

    print(f"#{tc} {answer}")

