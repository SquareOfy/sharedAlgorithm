n = int(input())
switches = list(map(int, input().split()))

m = int(input())
students = []
for _ in range(m):
    students.append(list(map(int, input().split())))

for p in students:
    num = p[1]
    if p[0] == 1:
        for i in range(num-1, n, num):
            switches[i] = (switches[i] + 1) % 2

    else:
        switches[num-1] = (switches[num-1] + 1) % 2
        j = 1
        while 1:
            if num-1 + j >= n or num-1 - j < 0: break
            if switches[num-1+j] != switches[num-1-j]: break
            switches[num-1+j] = (switches[num-1+j]+1) % 2
            switches[num-1-j] = (switches[num-1-j]+1) % 2
            j += 1


if len(switches) <= 20: print(*switches)
else:
    for i in range(len(switches)//20):
        print(*switches[20*i:20*(i+1)])

    if len(switches) % 20 != 0:
        print(*switches[20*(len(switches)//20):])