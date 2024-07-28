t = int(input())

for tc in range(t):
    h, w, n = map(int, input().split())
    answer_h  = n%h if n%h!=0 else h
    answer_w = n//h+1 if n%h !=0 else n//h
    answer_w = '{0:02d}'.format(answer_w)

    print(f"{answer_h}{answer_w}")