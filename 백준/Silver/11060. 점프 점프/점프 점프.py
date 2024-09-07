N = int(input())
A = list(map(int, input().split()))
ans = idx = t = 0


while True:
    t = A[idx]
    if idx >= N - 1:
        break
    ans += 1
    # 점프가능 칸수

    # index()에 걸리지 않도록 0으로 바꿔주기
    # A[idx] = 0

    # 0이 가장 큰값 => 0에서 더 이동 불가면 오른쪽 끝 갈 수 없음
    if t == 0:
        ans = -1
        break

    if idx + t >= N - 1:
        break
    # 가장 오른쪽끝 인덱스 도달한다면 탈출


    # 내 다음위치~이동가능 위치 중 가장 큰값으로 점프할거
    mx = 0
    cnt = idx
    # 가장 큰값으로 이동
    for i in range(idx + 1, idx + t + 1):
        if i+A[i] >= mx:
            idx= i
            mx = i+A[i]
        # cnt += 1
        # if i == mx:
        #     idx = cnt

print(ans)