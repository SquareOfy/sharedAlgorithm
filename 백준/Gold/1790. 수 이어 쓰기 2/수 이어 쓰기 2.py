n, k = map(int, input().split())
l = len(str(n))
seq_len = 0
k_idx = -1
k_len = -1
for i in range(l-1):
    seq_len += 9*(10**i)*(i+1)
    if k_idx == -1 and k<=seq_len:
        k_idx = seq_len - 9*(10**i)*(i+1)
        k_len = i+1

seq_len += (n-10**(l-1)+1)*l
if k>seq_len:
    print(-1)
else:
    if k_idx == -1:
        k_len = l
        k_idx = seq_len -  (n-10**(l-1)+1)*l

    for i in range(10**(k_len-1), 10**(k_len)):

        k_idx += k_len
        if k_idx >= k:
            seq_num = str(i)
            print(seq_num[k_len-1-(k_idx-k)])
            break
