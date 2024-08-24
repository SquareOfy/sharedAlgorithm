y_dict = {}
x_dict = {}
for i in range(3):
    y, x = map(int, input().split())
    if y in y_dict:
        y_dict[y] = y_dict[y]+1
    else:
        y_dict[y] = 1
    if x in x_dict:
        x_dict[x] = x_dict[x]+1
    else:
        x_dict[x] = 1
ans = [0, 0]
for i in y_dict.keys():
    if y_dict[i] == 1:
        ans[0] = i
for j in x_dict.keys():
    if x_dict[j] == 1:
        ans[1] = j
print(*ans)