from collections import deque
import sys

input = sys.stdin.readline
n = int(input())
innings = [list(map(int, input().split())) for _ in range(n)]

selected = [0] * 9
selected[3] = 0
visited = [0] * 9


def select_player(cnt):
    global answer
    if cnt == 9:
        count_score()
        return

    for i in range(1, 9):
        if not visited[i]:
            visited[i] = 1
            selected[cnt] = i
            if cnt + 1 == 3:
                select_player(cnt + 2)
            else:
                select_player(cnt + 1)
            visited[i] = 0


def count_score():
    idx = 0
    score = 0
    global answer
    for inn in innings:
        out = 0
        # ru = [0] * 3
        ru = deque([])
        while 1:
            now = inn[selected[idx]]
            if now == 0:
                out += 1
                if out >= 3:
                    idx += 1
                    idx %= 9
                    break
            elif now <= 4:
                size = len(ru)
                for k in range(size):
                    runner = ru.popleft()
                    runner += now
                    if runner>=4:
                        score+= 1
                    else:
                        ru.append(runner)
                if now == 4:
                    score+=1
                else:
                    ru.append(now)
            #     for k in range(3 - now, 3):
            #         score += ru[k]
            #         ru[k] = 0
            #     for k in range(2, now - 1, -1):
            #         ru[k] = ru[k - now]
            #         ru[k - now] = 0
            #     ru[now - 1] = 1
            #
            # else:
            #     score += sum(ru) + 1
            #     ru = [0] * 3
            idx += 1
            idx %= 9

    answer = max(answer, score)



answer = 0
select_player(0)
print(answer)
