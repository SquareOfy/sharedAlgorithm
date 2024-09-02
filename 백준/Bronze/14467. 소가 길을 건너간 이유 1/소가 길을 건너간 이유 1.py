n = int(input())
cows = [-1]*101
answer =0
for i in range(n):
    num, p = map(int, input().split())
    if cows[num] ==-1:
        cows[num] = p
    else:
        if cows[num] != p:
            cows[num] = p
            answer+=1
print(answer)