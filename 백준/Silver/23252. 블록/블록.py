t = int(input())

for tc in range(t):
    answer = "Yes"
    a, b, c = map(int, input().split())

    if a < c:
        answer = "No"
    else:
        if b % 2 != 0 and \
                not ( ((a-c)%2 ==0 and a>=2) or\
                      ((a-c)%2 ==0 and a!=0 and c!=0 )):
            answer = "No"
        elif b % 2 == 0 and (a - c) % 2 != 0:
            answer = "No"

    print(answer)
