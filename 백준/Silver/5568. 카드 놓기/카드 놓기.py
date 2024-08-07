n = int(input())
k = int(input())

lst = [int(input()) for _ in range(n)]
numbers = set() #지금까지 만든 정수 중복없이 저장하기 위한 set
answer = 0  #만들 수 있는 정수 개수 카운트할 변수
visited = [0] *n #해당 카드를 사용했는지 확인할 중복체크 배열


def dfs(idx, cnt, selected):
    global answer
    if cnt == k: #k개 카드 다 뽑았으면 지금까지 고른 카드 숫자로 조합
        num = ''.join(selected)
        if num not in numbers: #set에 없으면 answer+1하고 set에 넣기
            numbers.add(num)
            answer+=1
        return

    for i in range(n): #0 ~n-1개의 카드 중에 아직 뽑지 않은 카드 뽑아보기
        if visited[i]:
            continue
        visited[i] = 1
        dfs(i+1, cnt+1, selected+[str(lst[i])]) #다음 카드 뽑기
        visited[i] = 0


dfs(0, 0, [])
print(answer)