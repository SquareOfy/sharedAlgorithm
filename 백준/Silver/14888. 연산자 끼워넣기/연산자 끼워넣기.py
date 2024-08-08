n = int(input())

lst = list(map(int, input().split()))
cnt_lst = list(map(int, input().split()))

max_answer = -10**9
min_answer = 10**9
def calculate():
    answer = lst[0]
    for i in range(n-1):
        o = selected[i]
        if o == 0:
            answer += lst[i+1]
        elif o == 1:
            answer -= lst[i+1]
        elif o==2:
            answer *= lst[i+1]
        else:
            if answer<0:
                answer *= -1
                answer //= lst[i+1]
                answer *= -1
            else:
                answer //= lst[i+1]

    return answer



def set_operation(cnt):
    global max_answer, min_answer
    if cnt==n-1:
        answer = calculate()
        max_answer = max(max_answer, answer)
        min_answer = min(min_answer, answer)

        return

    for i in range(4):
        if cnt_lst[i] ==0:
            continue
        cnt_lst[i] -= 1
        selected.append(i)
        set_operation(cnt+1)
        selected.pop()
        cnt_lst[i] += 1


selected = []
set_operation(0)
print(max_answer)
print(min_answer)