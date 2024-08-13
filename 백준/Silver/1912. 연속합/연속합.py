"""
수열의 누적합 배열 sum_lst
누적합을 for문으로 한번만 돌며 answer를 그때까지 앞에서 본 값들 중
가장 작은 값과의 차와 sum_lst[i]값, answer를 비교해서 최댓값 갱신
그리고 sum_lst[i]가 현재까지의 now_min값보다 작으면 now_min 갱신
(이 다음 answer를 갱신할 때, 가장 작은 값이므로 사용될 것)
"""
n = int(input())
seq = [0]+list(map(int, input().split()))

sum_lst = [0]*(n+1)
for i in range(1, n+1):
    sum_lst[i] = sum_lst[i-1]+seq[i]
answer = seq[1]
now_min = 1001*n
for i in range(1, n+1):
    answer = max(max(sum_lst[i], sum_lst[i]-now_min), answer)
    if now_min > sum_lst[i]:
        now_min = sum_lst[i]
print(answer)

