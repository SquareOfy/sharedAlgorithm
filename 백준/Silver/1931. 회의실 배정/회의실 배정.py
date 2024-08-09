n = int(input())

arr = [list(map(int, input().split())) for i in range(n)]

#회의실을 최대한 많이 선택하기 위해
#끝나는 시간 기준으로 오름차순 정렬
#빨리 끝나는 회의실 우선 선택하고, 그 회의실 이후에 시작하는 회의실 중
#또 가장 빨리 끝나는 회의실 선택하면 됨

arr.sort(key=lambda x : (x[1], x[0]))

last = 0
answer = 0
for i in range(n):
    if last<=arr[i][0]: #직전에 선택한 회의 종료시간 이후에 회의 시작하면 선택
        last = arr[i][1]
        answer += 1

print(answer)