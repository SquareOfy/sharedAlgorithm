calculation = input()

answer_stk = []
oper_stk = []
def get_priority(i):
    if i =='(':
        return 3
    if i in '*/':
        return 2
    if i in '+-':
        return 1


for i in calculation:
    if i in '()+-*/':

        if i==')':
            while oper_stk and oper_stk[-1]!='(':
                answer_stk.append(oper_stk.pop())
            oper_stk.pop()
        elif not oper_stk or (oper_stk and get_priority(oper_stk[-1])< get_priority(i)):
            oper_stk.append(i)
        elif oper_stk and oper_stk[-1] == '(':
            oper_stk.append(i)
        else:
            while oper_stk and (oper_stk[-1] != '(' and get_priority(oper_stk[-1]) >= get_priority(i)):
                answer_stk.append(oper_stk.pop())
            oper_stk.append(i)


    else:
        answer_stk.append(i)

while oper_stk:
    answer_stk.append(oper_stk.pop())
print(''.join(answer_stk))