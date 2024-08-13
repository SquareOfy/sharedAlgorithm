def fibo(k):
    if k==0:
        return 0
    if fibo_lst[k] != 0:
        return fibo_lst[k]
    
    fibo_lst[k] =  fibo(k-1)+fibo(k-2)
    return fibo_lst[k]

n = int(input())
fibo_lst = [0]*(n+1)
fibo_lst[1] = 1
print(fibo(n))
