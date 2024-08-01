n, m = map(int, input().split())
cannot_hear = set()
cannot_see = set()
for i in range(n):
    cannot_hear.add(input())
for i in range(m):
    cannot_see.add(input())

result = list(cannot_see.intersection(cannot_hear))
result.sort()
print(len(result))
for i in result:
    print(i)