w, h = map(int, input().split())

n = int(input())
w_lst = [0, w]
h_lst = [0, h]
cut_lst = []
for _ in range(n):
    cut = list(map(int, input().split()))
    if cut[0] == 1:
        w_lst.append(cut[1])
    else:
        h_lst.append(cut[1])
w_lst.sort()
h_lst.sort()
w_max = 0
h_max = 0

for i in range(len(w_lst)-1):
    w_max = max(w_lst[i+1]-w_lst[i], w_max)
for i in range(len(h_lst)-1):
    h_max = max(h_lst[i+1]-h_lst[i], h_max)


print(w_max * h_max)