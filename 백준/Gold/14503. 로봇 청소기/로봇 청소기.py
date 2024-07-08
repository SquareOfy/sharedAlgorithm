import sys

input = sys.stdin.readline

dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]
findD = [0, 3, 2, 1]
cnt = 0

n, m = map(int, input().split())

room = []
visited = [[False]*m for _ in range(n)]

r, c, d = map(int, input().split())
d = findD[d]

for i in range(n):
    row = list(map(int, input().split()))
    room.append(row)



class Node:

    def __init__(self, r, c, d):
        self.r = r
        self.c = c
        self.d = d



def clean(r, c):
    flag = False
    for i in range(4):
        du = r+dr[i]
        dv = c+dc[i]
        if(du<0 or dv<0 or du>=n or dv>=m): continue
        if(room[du][dv]==0 and (not visited[du][dv])):
            flag = True
            break
    
    if(flag):
        while(True):
            global d
            d = (d+1)%4
            du = r + dr[d]
            dv = c + dc[d]
            if(du<0 or dv<0 or du>=n or dv>=m or room[du][dv]==1):
                continue
            if(not visited[du][dv]):
                visited[du][dv] = True
                global cnt
                cnt+=1
                clean(du, dv)
                break
    else:
        dir = (d+2)%4
        du = r+dr[dir]
        dv = c+dc[dir]
        if(du<0 or dv<0 or du>=n or dv>=m or room[du][dv]==1):
            return
        clean(du, dv)


if(room[r][c]==0):
    visited[r][c] = True
    cnt+=1

clean(r,c)

print(cnt)