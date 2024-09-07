n, k = map(int, input().split())
lst = list(input())
cr, cc = 0, 0
answer = "NO"
T = []
for i in range(min(k, n)):
    T.extend(lst)
d_dict = {'U':(0, -1), 'R':(1, 1), 'L' :(1, -1), 'D':(0, 1)}
cnt = [0, 0]
for i in range(n*min(k, n)):
    idx, num = d_dict[T[i]]
    cnt[idx] += num
    if cnt == [0,0]:
        answer = "YES"
        break
print(answer)