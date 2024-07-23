money = int(input())
cnt = 0
if money==0:
    print(-1)
elif money %5 ==0:
    print(money//5)
elif money%5 ==1 or money%5==3:
    if money//5 >= 1:
        print(money//5 - 1 + (money % 5 + 5) // 2)
    else:
        print(-1)
elif (money%5) % 2 == 0:
    print(money//5 + (money % 5) //2)

elif money%2 == 0:
    print(money//2)


