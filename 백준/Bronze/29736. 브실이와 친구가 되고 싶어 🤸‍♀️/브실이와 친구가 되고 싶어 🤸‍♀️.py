a, b = map(int, input().split())
k, x = map(int, input().split())
answer = min(b,k+x) - max(k-x, a) +1

print("IMPOSSIBLE" if answer <=0 else answer)