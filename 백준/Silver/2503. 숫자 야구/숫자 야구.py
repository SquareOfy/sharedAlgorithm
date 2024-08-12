def check_num(num):
    for r in range(n):
        called_num = str(arr[r][0])
        strike = 0
        ball = 0
        for x in range(3):
            if called_num[x] == num[x]:
                strike+=1
            elif called_num[x] in num:
                ball+=1
        if strike != arr[r][1] or ball != arr[r][2]:
            return False
    return True

n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]
answer = 0
for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            if i==j or i==k or j==k:
                continue
            str_num= str(i)+str(j)+str(k)
            result = check_num(str_num)
            if result:
                answer += 1
print(answer)