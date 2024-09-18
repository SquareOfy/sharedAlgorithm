def check(mid):
    attack = M
    hp = mid

    for t, a, h in arr:
        # print('-------------', t,a,h)
        if t == 1: #몬스터

            k = h // attack if h%attack==0 else h//attack+1
            c = hp // a if hp%a==0 else hp//a+1

            h %= attack
            hp -= a*(k-1)

            if k<=c:
                continue
            else:
                return False
        else:
            attack+=a
            hp = min(mid, hp+h)
    return True

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

left = 1
right = 1_000_000**2*N
answer = -1
while left<=right:
    mid = (left+right)//2
    if check(mid):
        answer = mid
        right = mid-1
    else:
        left = mid+1

print(answer)