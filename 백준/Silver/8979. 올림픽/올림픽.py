n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

arr.sort(reverse = True, key = lambda x : (x[1], x[2], x[3])) #금/은/동 많은 순대로 정렬

idx = 0
for i in range(n):
    if arr[i][0] == k:
        idx= i
        break

#나보다 위에 있는 국가 수 + 1로 answer 세팅
answer = idx+1
for i in range(idx):
    
    #나보다 위에있는 애들 중에 나랑 완전 동등한 국가는 빼기
    if arr[i][1] == arr[idx][1] and \
        arr[i][2] == arr[idx][2] and \
        arr[i][3] == arr[idx][3]:
        answer-= 1
print(answer)