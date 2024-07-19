def get_submit_answer(depth, score):
    global answer

    if depth == 10:
        # 점수 계산하기
        if(score>=5): answer += 1
        return

    # 5지 선다 중 하나 뽑기
    for i in range(1, 6):

        if depth > 1 and numbers[depth - 1] == i and numbers[depth - 2] == i:
            continue

        numbers.append(i)
        # 정답이면
        if i == answer_list[depth]:
            get_submit_answer(depth + 1, score + 1)
        else:
            get_submit_answer(depth + 1, score)
        numbers.pop()


answer_list = list(map(int, input().split()))

numbers = []
answer = 0
get_submit_answer(0, 0)
print(answer)
