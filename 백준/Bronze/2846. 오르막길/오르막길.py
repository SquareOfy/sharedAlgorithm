n = int(input())
h = list(map(int, input().split()))

answer = 0
start = 1000
end = 0
flag = False
for i in range(n-1):
    if h[i+1]>h[i]:
        if not flag:
            start = h[i]
        end = h[i+1]
        flag =True
    else:
        if flag:
            answer = max (answer, end - start)
        flag = False
answer = max(answer, end-start)
print(answer)
