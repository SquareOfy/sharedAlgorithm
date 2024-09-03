n, k = map(int, input().split())
answer = ['?']*n

arr = [list(input().split()) for _ in range(k)]
pointer = 0
flag = True
a = ord('A')
visited = [0]*26
for i in range(k):
    num = int(arr[i][0])
    ch = arr[i][1]
    pointer -= num
    pointer %= n
    if answer[pointer] == '?' and not visited[ord(ch)-a]:
        answer[pointer] = ch
        visited[ord(ch) -a] = 1
    elif answer[pointer]!=ch or (answer[pointer]=='?' and visited[ord(ch)-a]):
        flag=False
        break
if flag:
    for i in range(n):
        idx = (pointer+i)%n
        print(answer[idx], end="")
else:
    print("!")