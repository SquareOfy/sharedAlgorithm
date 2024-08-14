def find(a):
    if a == p[a]:
        return a
    p[a] = find(p[a])
    return p[a]

def union(x, y):
    x = find(x)
    y = find(y)
    p[x] = y
V,E = map(int, input().split())

edges = []
for e in range(E):
    st, ed, cost = map(int, input().split())
    edges.append((cost, st, ed))

edges.sort()
p = [i for i in range(V+1)]

answer = 0
cnt = 0
for e in edges:
    p_st = find(e[1])
    p_ed = find(e[2])
    if p_st != p_ed:
        union(p_st, p_ed)
        answer+= e[0]
        cnt+=1
    if cnt==V-1:
        break

print(answer)