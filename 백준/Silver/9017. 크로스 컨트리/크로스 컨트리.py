t = int(input())
for tc in range(t):
    n = int(input())
    lst = list(map(int, input().split()))
    score_lst = [i+1 for i in range(n)]
    score_dict = {}
    answer = []
    for i in range(n):
        if lst[i] in score_dict:
            score_dict[lst[i]].append(i)
        else:
            score_dict[lst[i]] = [i]

    #점수 조정
    for k, arr in score_dict.items():
        if len(arr) < 6:
            for j in arr:
                score_lst[j] = 0
                for k in range(j+1, n):
                    score_lst[k] -= 1
    for k, arr in score_dict.items():
        if len(arr) < 6:
            continue
        arr.sort()
        score = [score_lst[t] for t in arr]

        answer.append((k, sum(score[:4]), arr[4]))
    answer.sort(key = lambda x:(x[1], x[2]))

    print(answer[0][0])