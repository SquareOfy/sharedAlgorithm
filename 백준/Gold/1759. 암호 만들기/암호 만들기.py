l, c = map(int, input().split())

lst = list(input().split())

lst.sort()

selected = [0]*l


def perm(idx, cnt):
    if cnt == l:
        vowel = 0
        for i in 'aeiou':
            vowel += selected.count(i)
        if cnt - vowel < 2 or vowel <1:
            return
        print(*selected, sep='')
        return

    for i in range(idx, c):
        if l-cnt > c-i:
            return
        selected[cnt] = lst[i]
        perm(i+1, cnt+1)
        selected[cnt] = 0

perm(0, 0)