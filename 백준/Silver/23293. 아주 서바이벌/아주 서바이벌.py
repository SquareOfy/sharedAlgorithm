"""
M : 플레이어가 현재 위치한 지역에서 다른 지역으로 이동한다.
        현재 위치한 지역으로는 이동하지 않는다.
F : 현재 위치한 지역에서만 획득할 수 있는 소재 아이템 1개를 획득한다.
    x번 지역에서는 x번 소재 아이템을 획득한다.
    아이템의 수량은 충분해 부족할 일이 없으며, 한 플레이어가 같은 아이템을 여러 번
    획득할 수 있다.
C : 가지고 있는 서로 다른 종류의 두 소재 아이템을 1개씩 사용해 장비를 만든다.
A : 다른 플레이어 한 명을 공격한다. 오직 같은 지역에 있는 플레이어만 공격할 수 있다.

- 부정행위
플레이어가 현재 위치한 지역에서 얻을 수 없는 소재 아이템을 획득한 경우
플레이어가 가지고 있지 않은 소재 아이템을 사용해 조합하는 경우
플레이어가 다른 지역에 있는 상대 플레이어를 공격하는 경우
"""

T, N = map(int, input().split())
answer_idx = []
answer_player=set()
place = [1]*(N+1)
items = [[0]*54 for _ in range(N+1)]

for t in range(T):
    idx, player, act, *lst = input().split()
    idx = int(idx)
    player = int(player)
    lst = list(map(int, lst))

    if act == 'M':
        place[player] = lst[0]
    elif act == 'F':
        if lst[0] != place[player]:
            answer_idx.append(idx)
        items[player][lst[0]] +=1
    elif act == 'C':
        a, b = lst
        if not items[player][a] or not items[player][b]:
            answer_idx.append(idx)
        items[player][a] = max(0, items[player][a]-1)
        items[player][b] = max(0, items[player][b]-1)
    elif act == 'A':
        if place[player]!=place[lst[0]]:
            answer_idx.append(idx)
            answer_player.add(player)

print(len(answer_idx))
if len(answer_idx):
    print(*answer_idx)
print(len(answer_player))
if len(answer_player):
    answer_player = list(answer_player)
    answer_player.sort()
    print(*answer_player)