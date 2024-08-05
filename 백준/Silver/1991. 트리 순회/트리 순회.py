def pre_order(i):
    if i < 0:  #'.'일 땐 바로 끝내기
        return
    #pre order 순 대로 함수 호출 및 lst append
    #중위후위순회도 마찬가지
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

#알파벳을 배열 idx로 변환
def change_idx(a):
    return ord(a) - ord('A')

#배열 idx를 알파벳으로 변환
def change_alph(a):
    return chr(a + ord('A'))


n = int(input())
m = ord('A')
tree = [0] * (n + 1)

for i in range(n):
    #idx로 변환하여 값 받기
    st, left, right = map(change_idx, input().split())
    #tree에 자식들의 배열idx 값 저장
    #tree node의 값은 따로 저장하지 않고 
    #idx만 가지고 나중에 알파벳으로 변환해서 찾을 것
    tree[st] = [left, right]

pre_answer = []
in_answer = []
post_answer = []
pre_order(0)
in_order(0)
post_order(0)

#결과 출력
print(''.join(pre_answer))
print(''.join(in_answer))
print(''.join(post_answer))
