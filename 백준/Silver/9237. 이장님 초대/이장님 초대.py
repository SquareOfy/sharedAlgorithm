n = int(input())
trees = list(map(int, input().split()))

trees.sort(reverse=True)
day = 1+n

for i in range(n):
    trees[i] -= n-i-1


day += max(trees)
print(day)