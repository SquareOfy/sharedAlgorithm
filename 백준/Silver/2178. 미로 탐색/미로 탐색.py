
class Node():
    r = 0
    c = 0
    rank =0
    def __init__(self, r, c, rank):
        self.r = r
        self.c = c
        self.rank = rank



def bfs():
    global answer
    q = []
    q.append(Node(0,0, 1))

    while(len(q)!=0):
        now = q.pop(0)

        for i in range(4):
            du = now.r+dr[i]
            dv = now.c+dc[i]
            if(du<0 or dv<0 or du>=n or dv>=m or visited[du][dv]!=0 or miro[du][dv]==0):
                continue

            if(du==n-1 and dv==m-1):
                answer = min(answer, now.rank+1)
                continue

            q.append(Node(du, dv, now.rank+1))
            visited[du][dv] = 1




n, m = map(int, input().split())

miro = []

dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]

visited = [[0]*m for _ in range(n)]



for i in range(n):
    miro.append(list(map(int, input())))

answer = n*m+1
bfs()
print(answer)


