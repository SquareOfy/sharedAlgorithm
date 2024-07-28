n = int(input())

num = int(str(n%10) + str((n%10 + n//10)%10))
answer = 1
while(num != n):
    num = int(str(num%10) + str((num%10 + num//10)%10))
    answer+=1

print(answer)