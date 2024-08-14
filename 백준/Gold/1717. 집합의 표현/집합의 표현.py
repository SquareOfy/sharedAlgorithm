import sys
sys.setrecursionlimit(100000)
def find(a):
    if a == p[a]:
        return a
    p[a]=find(p[a])
    return p[a]
def union(a, b):
    a = find(a)
    b = find(b)
    p[a] = b

n, m = map(int, input().split())
p = [i for i in range(n+1)]
for i in range(m):
    o, a, b = map(int, input().split())
    #합집합 : union 하기
    if o == 0:
        union(a,b)
    #두 원소 같은 집합인지 확인
    elif o==1:
        #부모가 같으면 같은집합
        if find(a) == find(b):
            print('YES')
        else:
            print('NO')