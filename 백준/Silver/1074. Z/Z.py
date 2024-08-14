def split_recursion(l, i, j):
    global cnt,flag
    if flag:
        return
    if l == 1:
        if i==r and j==c:
            flag = True
            return
        cnt+=1

        return
    size = l//2
    #제1사분면
    if i<=r<i+size and j<=c<j+size:
        split_recursion(size, i, j)
    elif i<=r<i+size and j+size<=c:
        cnt+=size*size
        split_recursion(size, i, j+size)
    elif i+size<=r and j<=c<j+size:
        cnt+=size*size*2
        split_recursion(size, i+size, j)
    else:
        cnt+=size*size*3
        split_recursion(size, i+size, j+size)

n, r, c = map(int, input().split())
cnt = 0
flag = False
split_recursion(2**n, 0, 0)
print(cnt)