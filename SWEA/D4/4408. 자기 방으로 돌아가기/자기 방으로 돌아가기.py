t = int(input())

for tc in range(1,t+1):
    n = int(input())

    lst = [0]*200


    for k in range(n):
        target = list(map(int, input().split()))
        for i in range(2):
            if target[i] %2 ==0:
                target[i] = target[i]//2 -1
            else:
                target[i] = target[i]//2


        if target[0] <= target[1]:
            for i in range(target[0], target[1]+1):
                lst[i] += 1
        else:
            for i in range(target[1], target[0]+1):
                lst[i] += 1

    print(f"#{tc} {max(lst)}")
