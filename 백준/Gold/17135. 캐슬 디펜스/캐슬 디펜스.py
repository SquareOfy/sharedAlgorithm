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
        return
    #중복이 되면 안되므로 위와 직전에 idx-1까지 cnt-1번째 궁수 자리로 고안했다면,
    #이번 cnt번째 궁수의 자리는 그 이후 자리부터 고려
    #또한, 앞으로 뽑아야할 남은 궁수 수는 3-cnt이므로,
    #앞으로 넣을 수 있는 자리의 수가 남은 궁수 수만큼이 될 때까지만 고려하도록 index를 m+1-(3-cnt)로 세팅
    for i in range(idx, m-(3-cnt)+1):
        archer[cnt] = i #궁수 뽑고
        set_archer(cnt+1, i+1) #다음 궁수 뽑기 위해 호출

def distance(y, x, r, c):
    return abs(y - r) + abs(x - c)


def game():
    global answer
    # 처음 적의 위치를 deque에 넣기 (본 배열을 건드리지 않기 위함)
    q = deque([])

    # 이 때, 최단 거리가 같은 적이 여럿이면 왼쪽 열이 우선이므로!!
    # 반드시 for c in range(m)부터 해줘야 한다.
    # 이 순서를 지키지 않을거라면, 공격할 적이 여럿일 경우
    # 공격할 적을 갱신할 때, 열 번호를 잘 비교해서 갱신해야한다.
    for c in range(m):
        for r in range(n - 1, -1, -1):
            if arr[r][c] == 1:
                q.append((r, c))

    # 이번 게임에서 적을 공격한 횟수를 저장할 변수
    kill = 0

    # Queue에 원소가 있을 때 = 게임판에 적이 존재할 때
    while q:
        # 적을 공격한 횟수가 중복되지 않도록(여러 궁수가 같은 적을 공격할 때)
        # set으로 공격할 적을 관리할 것
        kill_set = set()

        # Queue 원소의 개수가 중간에 변동이 발생해도 적을 탐색할 때
        # Queue에 존재했던 적들만 고려할 수 있도록
        # 그 당시 queue의 len 기억
        now_enemy_cnt = len(q)

        # 각 궁수마다 어떤 적을 공격할지 기록
        kill_lst = [(-1, -1) for _ in range(3)]

        # 죽일 적 목록 만들기 (최단거리로!!)
        for i in range(3):
            # 이번 궁수가 공격할 수 있는 적의 최단거리
            min_d = n * m * 2
            # 이번 궁수
            arc = archer[i]

            # 현존하는 모든 적 탐색
            for j in range(now_enemy_cnt):
                # 현재 살펴볼 적
                now = q.popleft()
                # 현재 살펴보는 적과의 거리
                now_dist = distance(n, arc, now[0], now[1])  # 거리 계산
                # 주어진 조건에 부합하고 최단거리 갱신되면
                if now_dist <= d and now_dist < min_d:
                    # 이 적을 리스트에 기록
                    kill_lst[i] = now
                    # 최단거리도 갱신
                    min_d = now_dist
                # 아직 공격 전이므로 다시 queue에 넣어주기(다음 궁수를 위해서!)
                q.append(now)
            # 적을 죽이는게 가능하면(불가능할 수도 있으므로 체크해야 함)
            if kill_lst[i] != (-1, -1):
                # set에 넣기(궁수들이 같은 적을 죽이는 상황도 고려하기 위해)
                kill_set.add(kill_lst[i])
        # set에 있는 적들은 queue에서 제거(궁수들이 공격)
        for e in kill_set:
            q.remove(e)
            kill += 1

        now_enemy_cnt = len(q)  # 현재 queue 기록
        # 적 한칸 내리기
        for j in range(now_enemy_cnt):
            now = q.popleft()  # 적을 queue에서 꺼내서
            if now[0] + 1 >= n:  # 게임판에서 배제되는지 확인
                continue  # 배제
            q.append((now[0] + 1, now[1]))  # 배제 안되면 다시 queue에 1칸 아래 이동시킨 적 넣기

    # while문 종료되면 모든 적이 게임판에서 배제된 것이므로
    # kill값과 answer 비교 후 갱신
    answer = max(kill, answer)

set_archer(0, 0)
print(answer)
