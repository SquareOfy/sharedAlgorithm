def dfs(level, num):
    global mx, mn
    if level==n-1:
        mx = max(mx, num)
        mn = min(mn, num)
        return
    for i in range(4):
        if cnt[i] ==0:
            continue
        cnt[i]-=1
        dfs(level+1, calculate(i, num, lst[level+1]))
        cnt[i]+=1

def calculate(i, n, next):
    if i==0:
        return n+next
    elif i==1:
        return n-next
    elif i==2:
        return n*next
    else:
        if n<0:
            return -((-n)//next)
        return n//next
n = int(input())
lst = list(map(int, input().split()))
cnt = list(map(int, input().split()))
selected = [0] * (n-1)
mx = -10**9
mn = 10**9
dfs(0, lst[0])
print(mx)
print(mn)