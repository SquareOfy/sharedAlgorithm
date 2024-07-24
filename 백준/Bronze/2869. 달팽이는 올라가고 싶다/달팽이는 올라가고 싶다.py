a, b, v = map(int, input().split())
answer = ((v-a) // (a-b))

answer += 1
if (v-a) % (a-b) != 0:
    answer += 1
print(answer)