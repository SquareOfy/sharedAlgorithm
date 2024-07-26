n, m = map(int,(input().split()))
cards = list(map(int, input().split()))

gap = m
answer = 0
for i in range(n-2):
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            tmp = cards[i]+cards[j]+cards[k]
            if tmp <= m and m-tmp < gap:
                gap = m-tmp
                answer = tmp

print(answer)

