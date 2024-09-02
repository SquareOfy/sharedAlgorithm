# n = int(input())
#
# lst = [input for i in range(n)]

n = int(input())
lines = [list(map(int, input().split())) for _ in range(n)]

lines.sort(key = lambda x:(x[0], x[1]))
bs = 0
be = 0
answer =0
for i in range(n):
    st, ed = lines[i]
    if bs<=st and ed<=be:
        continue
    if st < be:
        answer += ed-be
    else:
        answer += ed-st
    bs = st
    be = ed
print(answer)