from collections import deque

n, m = map(int, input().split())
pq = deque([])
wq = deque([])
priority = [0] * (m+1)
for i in range(n):
     p, w = map(int, input().split())
     pq.append(p)
     wq.append(w)
     priority[p] +=1

stk = []
answer = 0

while pq and wq:
    p= pq.popleft()
    w = wq.popleft()
    answer += w
    #나보다 우선순위 낮은게 있으면 뒤로 넘겨
    mq = max(pq) if pq else 0

    if mq > p:
        pq.append(p)
        wq.append(w)
    elif not stk or stk[-1][0] >= p: #맨 위보다 내가 우선순위 높으면 무게 비교
        #우선순위가 더 높거나 같아도 무게가 더 낮으면 그냥 쌓아올리기
        if not stk or stk[-1][0] >p or (stk[-1][1]==p and stk[-1][1]>= w):
            stk.append((p,w))

        #우선순위 같지만 무게가 더 무거울 때 무게 더 가벼울 때까지 꺼내두기
        else:
            tmp = []
            while stk and stk[-1][0] == p and stk[-1][1]<w:
                answer += stk[-1][1]*2
                tmp.append(stk.pop())
            stk.append((p, w))

            while tmp:
                stk.append(tmp.pop())





print(answer)