from collections import deque
n, m = map(int, input().split())
dq = deque([i for i in range(1, n+1)])
lst = list(map(int, input().split()))
answer = 0

for i in lst:
    tmp_lst = list(dq) #index함수 사용하기 위해서 list로 변환
    l = tmp_lst.index(i) 

    if l < len(tmp_lst) - l: #양 끝 중 어디서 더 가까운지 판단
        for k in range(l): #앞쪽이 가까우므로 그 index만큼
            dq.rotate(-1) #왼쪽으로 이동
            answer += 1
    else:
        for k in range(len(tmp_lst)-l):
            dq.rotate() #오른쪽으로 이동
            answer+=1
    dq.popleft() #숫자 빼내기
print(answer)
