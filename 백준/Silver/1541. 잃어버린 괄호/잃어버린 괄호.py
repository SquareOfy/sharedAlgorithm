expression = input()


split_by_minus = expression.split('-')

minus_lst = []

for part in split_by_minus:

    split_by_plus = list(map(int, part.split('+')))
    minus_lst.append(sum(split_by_plus))

answer = minus_lst[0]
for i in range(1, len(minus_lst)):
    answer -= minus_lst[i]

print(answer)