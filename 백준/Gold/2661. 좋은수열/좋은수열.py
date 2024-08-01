n = int(input())
flag = False


def is_good_seq(seq):
    seq_len = len(seq)
    for l in range(1, seq_len // 2 + 1):
        for i in range(0, seq_len - (2 * l) + 1):
            if seq[i:i + l] == seq[i + l:i + (2 * l)]:
                return False
    return True


def make_seq(seq):
    global flag
    if flag:
        return
    if len(seq) == n:
        # 좋은 함수인지 체크
        if is_good_seq(seq):
            flag = True
            print(seq)
        return

    for i in range(1, 4):
        next = seq + str(i)
        if is_good_seq(next):
            make_seq(next)

make_seq('')