import sys

input = sys.stdin.readline

n, k = map(int, input().split())

students = [[0]*2 for _ in range(7)]

for i in range(n):
    gender, grade = map(int, input().split())
    students[grade][gender]+= 1

answer = 0

for i in range(1, 7):
    for j in range(2):
        if students[i][j] == 0: continue
        answer += students[i][j]//k
        if students[i][j] % k != 0:
            answer += 1

print(answer)