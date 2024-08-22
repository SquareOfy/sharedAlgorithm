h, w, n, m = map(int, input().split())
ah = 1 + (h-1)//(n+1)
aw = 1 + (w-1)//(m+1)

print(ah*aw)