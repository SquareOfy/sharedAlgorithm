t = int(input())

def get_num(k, n):
    if arr[k][n]:
        return arr[k][n]
    answer = 0
    for i in range(1, n+1):
        answer += get_num(k-1, i)
    arr[k][n] = answer
    return answer
arr = [[0]*(15) for _ in range(15)]
for i in range(1, 15):
    arr[0][i] = i
for tc in range(t):
    k = int(input())
    n = int(input())

    print(get_num(k, n))
