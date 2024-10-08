from collections import deque


def add_numbers(lst):
    lst = list(lst)
    for n in range(0, N, cnt):
        line = lst[n:n + cnt]
        num = 0
        for i in range(len(line)):
            n = line[i]
            v = 0
            if ord(n) - oa >= 0:
                v = 10 + ord(n) - oa
            else:
                v = int(n)
            num += 16 ** (cnt - 1 - i) * v
        s.add(num)


T = int(input())

oa = ord('A')
for t in range(1, T + 1):
    N, K = map(int, input().split())
    numbers = deque(list(input()))
    s = set()
    cnt = N // 4
    for i in range(cnt):
        add_numbers(numbers)
        numbers.rotate(1)
    s = list(s)
    s.sort(reverse=True)
    print(f"#{t} {s[K-1]}")