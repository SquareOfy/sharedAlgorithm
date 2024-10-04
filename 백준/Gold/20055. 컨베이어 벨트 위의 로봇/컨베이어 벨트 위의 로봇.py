"""
 무빙워크는 사람을 한 쪽 끝에서 반대쪽 끝으로 옮겨주는 기계
 다음과 같이 총 2n개의 판으로 구성
무빙워크의 레일은 시계 방향으로 회전 (1, 2N 연결됨)

각 사람은 1번 칸에 올라서서 n번 칸에서 내리게 됩니다.
사람이 어떤 칸에 올라가거나 이동하면
그 칸의 안정성은 즉시 1만큼 감소하게 되며 안정성이 0인 칸에는 올라갈 수 없습니다.

무빙워크가 한 칸 회전합니다.

가장 먼저 무빙워크에 올라간 사람부터 무빙워크가 회전하는 방향으로 한 칸 이동할 수 있으면 이동합니다.
만약 앞선 칸에 사람이 이미 있거나 앞선 칸의 안정성이 0인 경우에는 이동하지 않습니다.

1번 칸에 사람이 없고 안정성이 0이 아니라면 사람을 한 명 더 올립니다.

안정성이 0인 칸이 k개 이상이라면 과정을 종료합니다. 그렇지 않다면 다시 위의 과정을 반복합니다.

단, 1~3 과정 중 n번 칸 위치에 사람이 위치하면 그 즉시 내리게 됩니다.
각 칸의 안정성은 시간에 지남에 따라 다시 상승하지 않습니다.


무빙워크가 종료될 때 몇 번째 실험 중이었는지를 출력
"""
from collections import deque
#입력
N, K = map(int, input().split())
stability_lst = list(map(int, input().split()))
moving_q = deque([i for i in range(2*N)])
visited = [0]*(2*N)
answer = 0
cnt = 0
people_lst = []
#while
while 1:
    answer += 1
    #rotate
    moving_q.rotate(1)

    up = moving_q[0]
    down = moving_q[N-1]

    #N-1에 있는 사람 내리기
    visited[down] = 0
    # print()
    # print(moving_q)
    # print(visited)
    # print(people_lst)
    # print("stable : ", stability_lst)
    # print()

    new_people = []
    #사람이동 2*N 부터 순차적으로 볼 것.
    for i in people_lst:
        #사람 있으면 이동할 칸 보기
        if visited[i]:
            nxt = (i+1)%(2*N)
            #안정성 0이거나 앞 칸에 사람 있으면 이동 불가
            if stability_lst[nxt] ==0 or visited[nxt]:
                new_people.append(i)
                continue
            #앞칸 내리는 위치면 안정성만 -1
            #아니면 visited 처리도 하기

            if nxt != down:
                visited[nxt] = 1
                new_people.append(nxt)

            stability_lst[nxt] -= 1

            #안정성 앞자리 0 되면 cnt+1
            if stability_lst[nxt] == 0:
                cnt+=1

            #기존 visited해제
            visited[i] = 0
    people_lst = new_people[:]
    # 1에 사람 올리기
    if not visited[up] and stability_lst[up] > 0:
        visited[up] = 1
        people_lst.append(up)
        stability_lst[up] -= 1
        if stability_lst[up] == 0:
            cnt += 1
    #종료조건 체크
    if cnt>=K:
        break
print(answer)
