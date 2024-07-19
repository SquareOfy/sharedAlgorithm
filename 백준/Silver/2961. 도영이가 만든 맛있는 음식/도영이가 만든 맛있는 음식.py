n = int(input())
ingredients = list()
answer = 1000000000
for _ in range(n):
    ingredients.append(list(map(int, input().split())))


def brute_force(cnt, depth, idx, sour, bitter):
    global answer
    if depth == cnt:
        answer = min(answer, abs(sour - bitter))

        return

    for i in range(idx, n):
        if cnt - depth > n - i: break
        brute_force(cnt, depth + 1, i + 1, sour * ingredients[i][0], bitter + ingredients[i][1])


for i in range(1, n + 1):
    brute_force(i, 0, 0, 1, 0)

print(answer)
