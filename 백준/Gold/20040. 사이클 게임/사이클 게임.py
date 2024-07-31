n, m = map(int, input().split())
edges = [[] for _ in range(n)]

line_input = [list(map(int, input().split())) for _ in range(m)]
p = [i for i in range(n)]


def union(x, y):
    a = find(x)
    b = find(y)
    if a < b:
        p[b] = a
    elif a > b:
        p[a] = b
    else:
        return 1

def find(x):
    if x == p[x]:
        return x
    return find(p[x])

answer =0

for i in range(m):
    x, y = line_input[i]
    # if find(x) == find(y):
    #     answer = i+1
    #     break
    if union(x, y):
        answer = i+1
        break

print(answer)