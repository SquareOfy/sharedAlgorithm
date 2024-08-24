n = int(input())
cnt = 0
for i in range(n):
    s = int(input())
    cnt+=s
print("Junhee is not cute!" if n-cnt>cnt else "Junhee is cute!")