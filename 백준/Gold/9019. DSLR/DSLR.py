from collections import deque
T = int(input())


def change_str(i):
    i = str(i)
    for k in range(4-len(i)):
        i = '0'+i
    return i


def bfs(a, b):
    q = deque([(a, [])])
    visited[int(a)] = 1

    while q:
        cur, lst = q.popleft()
        # print(cur, lst)
        if int(cur) == int(b):
            return lst

        d = (int(cur)*2)%10000
        if not visited[d]:
            visited[d] = 1
            q.append((change_str(d), lst+['D']))
        s = int(cur)
        if s ==0:
            s = 9999
        else:
            s = int(cur) - 1

        if not visited[s]:
            visited[s] = 1
            q.append((change_str(s), lst+['S']))

        l = cur[1:]+cur[0]
        if not visited[int(l)]:
            visited[int(l)] = 1
            q.append((l, lst+['L']))

        r = cur[3]+cur[:3]
        if not visited[int(r)]:
            visited[int(r)] = 1
            q.append((r, lst+['R']))


    return []


for t in range(T):
    a, b = input().split()
    a = change_str(int(a))
    b = change_str(int(b))
    visited = [0]*(10001)
    answer = bfs(a, b)
    print(*answer, sep= "")
