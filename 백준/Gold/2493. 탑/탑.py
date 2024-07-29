#idea
#왼쪽에 있는 자기보다 큰 값 중 가장 가까운 값의 idx를 찾는 문제
#자기 자신보다 왼쪽에 있는 값을 넣어야 하므로 왼쪽부터 오른쪽으로 가며 stack에 숫자를 넣을 것.
#인덱스도 스택에 함께 넣기
# 시행착오 : 현재 보고 있는 lst 값을 위해 pop한 개수를 cnt해서 거리를 구하고자 했으나,
# 앞에서도 그 사이에 pop을 했다면 cnt값이 reset되어
# stack top에 있는 수와 lst값의 거리를 알 수 없음

#숫자를 넣기 전에, stack이 비어있지 않다면,
# stack의 top이 자기 자신(lst값)보다 작으면 pop
# top이 자기 자신과 같거나 커지는 순간 레이저 신호가 수신 가능하므로
# idx 값 answer에 넣기
# 자신보다 같거나 큰 top이 생기지 않는 경우(stack의 len이 0 이됨)
# answer은 초기값이 그대로 남게 됨( 0 )
# 위 과정을 모두 수행하면 자기 자신도 stack에 넣고 다음 값 확인하러 가기
n = int(input())
lst = list(map(int, input().split()))
stack = []
answer = [0]*n
last = 0

for i in range(n):
    while stack and stack[-1][0] < lst[i]:
        stack.pop()
    if stack and stack[-1][0] >= lst[i]:
        answer[i] = stack[-1][1]
    stack.append([lst[i], i+1])

print(*answer)