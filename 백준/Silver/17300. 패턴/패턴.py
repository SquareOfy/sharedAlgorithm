L = int(input())
password = list(map(int, input().split()))
visited = [False] * 10

# 각 인덱스에서 가지 못하는 칸
c_nums = [
    [],
    [3, 7, 9],
    [8],
    [1, 7, 9],
    [6],
    [],
    [4],
    [1, 3, 9],
    [2],
    [1, 3, 7]
]

# 위 칸을 지나가려고 할 때 가운데에 끼는 숫자들
barrier = [
    [],
    [2, 4, 5],
    [5],
    [2, 5, 6],
    [5],
    [],
    [5],
    [4, 5, 8],
    [5],
    [5, 6, 8]
]

visited[password[0]] = True
idx = 1

flag = True
while True:
    if idx == len(password):
        break

    # 입력받은 패스워드 중 현재의 인덱스 값이 이전 번호의 c_nums에 있다면 갈 수 없는 넘버에 해당함
    if password[idx] in c_nums[password[idx-1]]:
        for j in range(len(c_nums[password[idx-1]])):
            # 근데 다 못가는 건 아니고 그 중간 barrier에 해당하는 값을 이미 방문했다면 지나칠 수 있으니까
            # 지나쳤는지 visited를 확인하는 코드
            if password[idx] == c_nums[password[idx-1]][j]:  # 이건 해당하는 barrier 값 찾기 위한 if 문
                if visited[barrier[password[idx-1]][j]]: break  # 만약에 이전에 방문했으면 지나갈 수 있으니까 나가고
                flag = False  # 아니라면 flag 바꿔줌
                break

    # 위의 if문과 별개로 현재 위치가 이미 이전에 방문한 적이 있다면 못 지나감
    if visited[password[idx]]:
        flag = False
        break

    if not flag: break

    visited[password[idx]] = True
    idx += 1

if flag:
    print('YES')
else:
    print('NO')