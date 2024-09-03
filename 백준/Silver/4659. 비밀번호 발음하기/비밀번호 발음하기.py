vowel = 'aeiou'
def contain_vowel():
    for o in vowel:
        if o in password:
            return True
    return False
def judge():
    l = len(password)
    v = 0
    c = 0
    if not contain_vowel():
        return False
    for i in range(l):
        p = password[i]
        if p in vowel:
            v += 1
            c = 0
            if v == 3:
                return False

        else:
            c += 1
            v = 0
            if c==3:
                return False
        if i+1<l and p == password[i+1] and p!='e' and p!='o':
            return False
    return True

while 1:
    password = input()
    if password=='end':
        break
    if judge():
        print(f"<{password}> is acceptable.")
    else:
        print(f"<{password}> is not acceptable.")



