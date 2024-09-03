n = input()

visited = [0]*10

for i in n:
    num = int(i)
    if num ==6 or num ==9:
        if visited[6]< visited[9]:
            num = 6
        else:
            num = 9

    visited[num] += 1
print(max(visited))