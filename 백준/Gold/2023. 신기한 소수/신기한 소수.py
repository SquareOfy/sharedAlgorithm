n = int(input())


def is_prime(k):
    if k==0 or k==1:
        return False
    if k == 2:
        return True
    l = int(k ** (0.5))
    for i in range(2, l + 1):
        if k % i == 0:
            return False
    return True



def dfs(level, num):
    if level == n:
        if is_prime(num):
            print(num)
        return
    for i in range(10):
        if is_prime(num*10+i):
            dfs(level+1, num*10+i)

dfs(0, 0)


