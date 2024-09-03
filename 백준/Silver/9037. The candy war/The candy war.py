t = int(input())
def check():
    c = candy[0]
    for i in range(1, n):
        if candy[i] != c:
            return False
    return True
for tc in range(t):
    n = int(input())
    candy = list(map(int, input().split()))
    next = [0]*n
    for i in range(n):
        if candy[i] %2 !=0:
             candy[i] += 1
    answer = 0
    while 1:
        if check():
            break
        for i in range(n):
            ni = (i+1)%n
            # if (candy[i]//2)%2==0:
            next[ni] = candy[i]//2
            candy[i] //=2
            # else:
            #     next[ni] = (candy[i]//2)+1
            #     candy[i] //=2
            #     candy[i] += 1
        for i in range(n):
            candy[i] += next[i]
            if candy[i]%2!=0:
                candy[i]+=1
            next[i] = 0

        answer += 1
    print(answer)
