import sys
sys.setrecursionlimit(100000)
n = int(input())

#간선 입력받기
edges = [[] for i in range(n+1)]
for i in range(n-1):
    a, b = map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)
    
p = [0]*(n+1)
p[1] = -1 #루트 표시하기
def dfs(k, before):
    #이전에 온 노드로 부모 표시
    p[k] = before
    #연결된 노드 중 부모가 연결되지 않은 노드들만 dfs로 탐색하여 부모 표시
    for e in edges[k]:
        if p[e] == 0:
            dfs(e, k)

#루트 노드부터 시작해서 dfs로 따라가며 부모 표시
for e in edges[1]:
    dfs(e, 1)


for i in range(2, n+1):
    print(p[i])

