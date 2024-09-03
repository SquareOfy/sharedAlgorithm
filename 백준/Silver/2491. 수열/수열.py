n = int(input())
lst = list(map(int, input().split()))
bigger = 1
smaller = 1
answer = 1
for i in range(1, n):
    if lst[i]>lst[i-1]:
        bigger+=1
        smaller=1
    elif lst[i]==lst[i-1]:
        bigger+=1
        smaller+=1
    else:
        bigger=1
        smaller+=1
    answer = max(answer, max(bigger, smaller), answer)
print(answer)