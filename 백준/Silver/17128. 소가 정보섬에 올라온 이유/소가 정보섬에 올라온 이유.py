n, q = map(int, input().split())

lst = list(map(int, input().split()))
q_lst = list(map(int, input().split()))

value = 0
for i in range(n):
    tmp = 1
    for j in range(4):
        tmp*= lst[(i+j)%n]
    value+= tmp
for i in range(q):
    idx = q_lst[i]-1

    for k in range(4):
        tmp = 1
        for j in range(4):
            tmp *= lst[(idx-k+j)%n]
        value -= tmp*2
    lst[idx] *= -1
    print(value)