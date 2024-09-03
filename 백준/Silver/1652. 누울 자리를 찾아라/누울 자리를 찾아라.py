n = int(input())
def check(i):
    cnt = 0
    l = 0
    for j in range(n):
        if arr[i][j] == '.':
            l+=1
        else:
            if l>=2:
                cnt+=1
            l =0 
        if j==n-1 and l>=2:
            cnt+=1
    return cnt
arr = [list(input()) for i in range(n)]
r = 0
c = 0
for i in range(n):
    r += check(i)

arr = list(zip(*arr))

for j in range(n):
    c+=check(j)
print(r, c)