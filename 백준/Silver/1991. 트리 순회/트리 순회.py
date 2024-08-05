def pre_order(i):
    if i < 0:
        return
    pre_answer.append(change_alph(i))
    pre_order(tree[i][0])
    pre_order(tree[i][1])


def in_order(i):
    if i < 0:
        return
    in_order(tree[i][0])
    in_answer.append(change_alph(i))
    in_order(tree[i][1])


def post_order(i):
    if i < 0:
        return
    post_order(tree[i][0])
    post_order(tree[i][1])
    post_answer.append(change_alph(i))


def change_idx(a):
    return ord(a) - ord('A')


def change_alph(a):
    return chr(a + ord('A'))


n = int(input())
m = ord('A')
tree = [0] * (n + 1)

for i in range(n):
    st, left, right = map(change_idx, input().split())
    tree[st] = [left, right]

pre_answer = []
in_answer = []
post_answer = []
pre_order(0)
in_order(0)
post_order(0)

print(''.join(pre_answer))
print(''.join(in_answer))
print(''.join(post_answer))
