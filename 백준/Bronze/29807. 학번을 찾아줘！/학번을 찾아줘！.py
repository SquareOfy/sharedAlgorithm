t = int(input())
lst = list(map(int, input().split()))
for i in range(0, 5-t):
    lst.append(0)
answer = 0
if lst[0]>lst[2]:
    answer += (lst[0]-lst[2])*508
else:
    answer += (lst[2]-lst[0])*108
if lst[1]>lst[3]:
    answer += 212 *(lst[1]-lst[3])
else:
    answer += 305 *abs((lst[1]-lst[3]))
if t ==5:
    answer+= lst[4]*707
answer *= 4763
print(answer)