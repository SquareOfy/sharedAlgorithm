import sys
sys.setrecursionlimit(10000)

t = int(input())

#나의 조상들을 표기할 dfs 
#첫번째 노드를 체크할 땐 멈추는 것 없이 루트노드까지 표기할 것
#두번째 노드의 bfs는 이미 visited라면 더 올라가지 않고 
#그 노드의 값을 return할 것
def dfs(i):
    #처음에 들어오자마자 visited면 첫번째 노드와 같은 노드인 것
    #바로 return. 방문한적 없는 노드면 visited체크하고 부모노드 체크하러 가기
    if not visited[i]:
        visited[i] = 1
    else:
        return i
    #부모 노드 방문한 적 없으면 dfs 재귀호출
    if not visited[p[i]]:
        return dfs(p[i])
    else:#방문한적 있으면 가장 가까운 조상노드이므로 return
        return p[i]

for tc in range(t):
    n = int(input())
    p = [0]*(n+1) #부모노드 기록하는 배열
    for i in range(n-1):
        x, y = map(int, input().split())
        p[y] = x
    a, b = map(int, input().split())
    visited = [0]*(n+1)
    #a의 조상들 모두 visited 표기
    dfs(a)
    #visited 겹치는 순간 return되는 값 answer에 저장하여 출력
    answer = dfs(b)
    print(answer)