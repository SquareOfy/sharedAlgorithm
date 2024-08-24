def seperate(n, cnt):
    l = len(n)
    global mx, mn
    if l==1:
        #cnt 갱신
        mn = min(cnt+int(n)%2, mn)
        mx = max(mx, cnt+int(n)%2)
        return
    if l==2:
        a = int(n)//10
        b = int(n)%10
        seperate(str(a+b), cnt+a%2+b%2)
        return
    tmp = 0
    for i in range(l):
        tmp += int(n[i])%2
    for s in combination[l-1]:
        a = n[:s[0]]
        b = n[s[0]:s[1]]
        c = n[s[1]:]
        seperate(str(int(a)+int(b)+int(c)), cnt+tmp)


def dfs(m, level, selected, idx):#m개중에 2개를 뽑는 dfs
    if level==2:
        combination[m].append(selected)
        return
    if 2-level> m-idx+1:
        return
    for i in range(idx, m+1):
        dfs(m, level+1, selected+[i], i+1)

# 9C2 ~ 3C2를 만들어놓자 '
combination = [[] for _ in range(10)]
for i in range(2, 10):
    dfs(i, 0, [], 1)


n = input()
mx = 0
mn = 10**9
seperate(n, 0)
print(mn, mx)