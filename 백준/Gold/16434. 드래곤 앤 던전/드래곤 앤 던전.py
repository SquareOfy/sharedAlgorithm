N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
answer = 0
tmp =0
for t, a, h in arr:
    if t==1:
        k = h//M+1 if h%M else h//M #몬스터 죽이기 위해 필요한 공격횟수
        tmp += (k-1)*a #그 때 깎이는 내 hp
        answer = max(tmp, answer)
    else:
        answer = max(tmp, answer)
        M+=a
        tmp = max(tmp-h, 0)
print(answer+1)