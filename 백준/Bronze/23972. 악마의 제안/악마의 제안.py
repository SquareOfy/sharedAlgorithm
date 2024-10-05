K, N = map(int, input().split())
if N == 1:
    print(-1)
else:
    X = K*N // (N-1)
    R = K*N % (N-1)
    print(X if R==0 else X+1)