"""
1640 문제이해완



============구상 및 주의점 ================
연쇄적으로 회전이 발생한다는 점과
한번 회전한 의자는 회전 안한다는 점에 주의할 것

함수 매개변수
idx : 회전시킬 의자의 번호
d : 회전방향
from : 회전이 어떤 방향에서 왔는지(어느방향으로 퍼지는 중인지)
    -이면 왼쪽 확인할 것 +1이면 오른쪽 확인할것 0이면 시작시점

왼쪽을 변화하는지 볼 때는 나의 pointer+2와 상대의pointer +5비교
오른쪽은 나의 p + 5와 상대의 p+2
"""

def rotate_chair(idx, d, fm):
    #회전시키기
    rotate_lst[idx] = d
    #왼쪽회전함수 호출
    if fm == -1 or fm ==0:
        if idx-1 >=0:
            p = (pointer[idx]+6)%8
            yp = (pointer[idx-1]+2)%8

            if arr[idx][p] != arr[idx-1][yp]:
                # print("왼")
                rotate_chair(idx-1, -d, -1)
    if fm==1 or fm==0:
        if idx+1<4:

            p = (pointer[idx] + 2) % 8
            yp = (pointer[idx+1] + 6) % 8
            # print(p, yp)
            # print(arr[idx][p], arr[idx+1][yp])
            if arr[idx][p] != arr[idx+1][yp]:
                # print("오")
                rotate_chair(idx+1, -d, 1)

pointer = [0]*4
arr = [list(map(int, list(input()))) for i in range(4)]
k = int(input())
for i in range(k):
    rotate_lst = [0] * 4

    idx, d = map(int, input().split())
    # print(idx, d)
    rotate_chair(idx-1, d, 0)
    # print(pointer)

    for j in range(4):
        pointer[j] = (pointer[j] - rotate_lst[j]) % 8
    # print(pointer)
    # print(rotate_lst)
    # print('-------')

# print(pointer)
answer =0
for i in range(4):
    p = pointer[i]
    answer += (2**i)*arr[i][p]

print(answer)