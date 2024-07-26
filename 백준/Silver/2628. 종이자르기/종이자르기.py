w, h = map(int, input().split())
n = int(input())

w_lst = [0,w]
h_lst = [0,h]
for i in range(n):
    way, k = map(int, input().split())
    if way == 0:
        h_lst.append(k)
    else:
        w_lst.append(k)

w_lst.sort()
h_lst.sort()

max_w = 0
max_h = 0
for i in range(1, len(w_lst)):
    if w_lst[i]-w_lst[i-1]>max_w:
        max_w = w_lst[i]-w_lst[i-1]
for j in range(1, len(h_lst)):
    if h_lst[j]-h_lst[j-1]>max_h:
        max_h = h_lst[j]-h_lst[j-1]

print(max_w*max_h)

