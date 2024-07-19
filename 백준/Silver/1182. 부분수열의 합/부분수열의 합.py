n, s = map(int, input().split())
seq = list(map(int, input().split()))

answer = 0


def brute_force(idx, num_sum):
    global answer

    if idx == n:
        return

    brute_force(idx+1, num_sum+seq[idx])
    if(num_sum+seq[idx]==s): answer+= 1
    brute_force(idx+1, num_sum)


brute_force(0, 0)
print(answer)

