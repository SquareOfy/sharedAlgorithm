from collections import deque

n, m, d = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
arr.append([0] * m)
answer = 0
archer = [0] * 3

def set_archer(cnt, idx):
    if cnt == 3:
        # 현재까지 세팅한 궁수 자리에서 게임 진행하기
        game()
        # print(archer)
        return

    for i in range(idx, m-(3-cnt)+1):
        archer[cnt] = i
        set_archer(cnt+1, i+1)

def distance(y, x, r, c):
    return abs(y - r) + abs(x - c)

def game():
    # print("======",archer,"========")
    global answer
    # 처음 적의 위치를 deque에 넣기 (본 배열을 건드리지 않기 위함)
    q = deque([])
    for c in range(m):
        for r in range(n - 1, -1, -1):
            if arr[r][c] == 1:
                q.append((r, c))
    kill = 0

    while q:
        # print('----------------')
        kill_set = set()
        now_enemy_cnt = len(q)
        kill_lst = [(-1, -1) for _ in range(3)]

        # 죽일 적 목록 만들기 (최단거리로!!)
        for i in range(3):
            min_d = n * m * 2
            arc = archer[i]

            for j in range(now_enemy_cnt):
                now = q.popleft()
                now_dist = distance(n, arc, now[0], now[1])  # 거리 계산

                if now_dist <= d and now_dist < min_d:
                    kill_lst[i] = now
                    min_d = now_dist
                q.append(now)
            if kill_lst[i] != (-1, -1):
                kill_set.add(kill_lst[i])
        # print(kill_lst)

        for e in kill_set:
            q.remove(e)
            kill += 1

        now_enemy_cnt = len(q)
        # 적 한칸 내리기
        for j in range(now_enemy_cnt):
            now = q.popleft()
            if now[0] + 1 >= n:
                continue
            q.append((now[0] + 1, now[1]))

    answer = max(kill, answer)

set_archer(0, 0)
print(answer)
