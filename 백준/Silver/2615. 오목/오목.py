# 머리에 떠오른다고 냅다 코드부터 지저분하게 적지 말자 ....

n = 19
arr = [list(map(int, input().split())) for _ in range(n)]
direction = ((1, 0), (0, 1), (1, 1), (-1, 1))


def check_omok():
    for i in range(n):
        for j in range(n):
            if arr[i][j] != 0:
                a = arr[i][j]
                for d in direction:
                    br = i - d[0]
                    bc = j - d[1]
                    if 0 <= br < n and 0 <= bc < n and arr[br][bc] == a:
                        continue
                    cnt = 1
                    for k in range(1, 6):
                        du = i + d[0]*k
                        dv = j + d[1]*k
                        if du < 0 or dv < 0 or du >= n or dv >= n:
                            break

                        if arr[du][dv] != a:
                            break
                        cnt += 1
                    if cnt == 5:
                        return a, i + 1, j + 1
    return 0, 0, 0


a, r, c = check_omok()
print(a)
if a != 0:
    print(r,c)