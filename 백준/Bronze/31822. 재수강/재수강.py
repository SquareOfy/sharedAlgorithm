again = input()
n = int(input())
lst = [input()[:5] for _ in range(n)]
print(lst.count(again[:5]))