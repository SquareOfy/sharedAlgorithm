n = int(input())

calculation = input()
stk = []

lst = [int(input()) for i in range(n)]

idx_minus = ord('A')
def calculate(a, b, o):
    if o=='+':
        return a+b
    elif o=='-':
        return a-b
    elif o=='*':
        return a*b
    else:
        return a/b

for i in calculation:
    if i not in '+-*/':
        stk.append(lst[ord(i)-idx_minus])
    else:
        a = stk.pop()
        b = stk.pop()
        stk.append(calculate(b,a,i))
answer = stk.pop()
print(f"{answer:.2f}")