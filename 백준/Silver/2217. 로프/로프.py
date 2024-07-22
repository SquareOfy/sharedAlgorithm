import sys

input = sys.stdin.readline

n = int(input())
rope = [int(input()) for _ in range(n)]

rope.sort(reverse=False)
answer = rope[0]*n

#i개의 로프를 사용 했을 때
for i in range(1, n):
    #가장 무거운 중량은 가장 약한 rope*i
    answer = max(answer, rope[n-i]*i)

print(answer)