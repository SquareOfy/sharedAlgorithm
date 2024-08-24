n = int(input())
mnr = 10001
mnc = 10001
mxr = -10001
mxc = -10001
for i in range(n):
    x, y = map(int, input().split())
    mnr = min(y, mnr)
    mnc = min(x, mnc)
    mxr = max(y, mxr)
    mxc = max(x, mxc)
print((mxr-mnr)*(mxc-mnc))