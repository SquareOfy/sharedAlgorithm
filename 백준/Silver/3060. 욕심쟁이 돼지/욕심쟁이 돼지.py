t = int(input())

for tc in range(t):
    n = int(input())
    lst = list(map(int, input().split()))
    feed = sum(lst)
    answer = 1
    while 1:
        if feed > n:
            break
        feed *= 4
        answer +=1

    print(answer)