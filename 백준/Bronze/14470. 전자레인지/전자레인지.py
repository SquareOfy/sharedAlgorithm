a, b, c, d, e = list(int(input()) for i in range(5))
ans = 0
if a<0:
    ans += (-a)*c+d

ans += (b-max(a, 0))*e
print(ans)