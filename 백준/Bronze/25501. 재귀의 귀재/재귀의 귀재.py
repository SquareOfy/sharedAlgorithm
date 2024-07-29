t = int(input())

def recursion(s, l, r):
    global cnt
    cnt +=1
    if l >= r:
        return 1
    elif s[l] != s[r]:
        return 0
    return recursion(s, l+1, r-1)


def isPalindrome(s):
    result = recursion(s, 0, len(s)-1)
    return result

for tc in range(t):
    cnt = 0
    s = input()
    print(isPalindrome(s), cnt)

