str1, str2 = input().split()

if len(str1) > len(str2):
    str1, str2 = str2, str1


def calculate(str1, str2):
    result = 0
    for i in range(len(str1)):
        if str1[i] != str2[i]:
            result += 1

    return result


if len(str1) == len(str2):
    print(calculate(str1, str2))

else:
    answer = len(str2)
    gap = len(str2) - len(str1)

    for i in range(gap+1):
        new_str1 = str2[0:i]+str1+str2[len(str1)+i:len(str2)]
        answer = min(answer, calculate(new_str1,str2))


    print(answer)