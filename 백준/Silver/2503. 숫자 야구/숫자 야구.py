n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
answer = 0
for a in range(1, 10):
    for b in range(1, 10):
        for c in range(1, 10):
            if a == b or b == c or c == a:
                continue
            num = "{0}{1}{2}".format(str(a), str(b), str(c))
            cnt = 0
            for lst in arr:
                call = str(lst[0])
                strike = 0
                ball = 0
                for j in range(3):
                    if num[j] in call:
                        idx = call.index(num[j])
                        if idx == j:
                            strike += 1
                        else:
                            ball += 1
                if strike == lst[1] and ball == lst[2]:
                    cnt += 1
            if cnt == len(arr):
                answer += 1

print(answer)
