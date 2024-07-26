n, m, b = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

min_h = 257
max_h = -1
cnt_lst = [0] * 257

def flatten(h):
    bag = b
    t = 0
    for i in range(h+1, max_h+1):
        bag += cnt_lst[i]*(i-h)
        t += 2*(i-h)*cnt_lst[i]
    for i in range(min_h, h):
        bag -= (h-i)*cnt_lst[i]
        if bag<0:
            return -1
        t += (h-i)*cnt_lst[i]
    return t


for l in arr:
    for i in l:
        cnt_lst[i] += 1
        if i > max_h:
            max_h = i
        elif i<min_h:
            min_h = i

answer = n*m*256+1
answer_h = 0
#min_h부터 max_h까지로 모두 땅을 고르게 만들어보기
for h in range(min_h, max_h+1):
    time = flatten(h)
    if time != -1 and time<=answer:
        answer = time
        answer_h = h

print(answer, answer_h)