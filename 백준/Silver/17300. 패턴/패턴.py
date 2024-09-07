"""
구상
# 3*3*[] 3차원 배열 준비
# 숫자 => 배열 좌표로 변환하는 룩업테이블 준비

# lst를 돌며 그 숫자가 있는 좌표에 어떤 방향으로 왔는지 []에 있는지 체크 후 append
# 만약 그 방향이 lst에 이미 있다면 불가능

# 방향은 어떻게 찾지?


# 이번 숫자의 좌표와 이전 숫자의 좌표 구하고 거리가 taxi dist만큼 for문을 돌며
#  그 방향으로 가면서 [] 에 있으면 불가능 없으면 넣고 다음 인덱스

# 방향으로 가는 거 어떻게 표현?
# dist = 택시 거리
# 좌표 차이 (a, b) 이면  a//(abs(a)) , b//(abs(b))를 방향벡터로 쓰기
==============================
구현 완료 후 빈틈 발견

1 -> 6으로 가는 경우는 우쨔냐????  그냥 가지려나?
안된다 ;;

"""
def check():
    global answer
    for i in range(1, N):
        bf = point_dict[lst[i-1]]
        cur = point_dict[lst[i]]
        d = [cur[0] - bf[0], cur[1] - bf[1]]

        dist = max(abs(d[0]), abs(d[1]))
        if dist == 0:
            answer = "NO"
            return
        #둘 중 하나라도 0이면
        if d[0]==0 or d[1]==0:
            d = [d[0] // abs(d[0]) if d[0]!=0 else 0, d[1] // abs(d[1]) if d[1]!=0 else 0]
        else: #둘다 0이 아니면
            dist = (abs(d[0])+abs(d[1]))//2
            if abs(d[0])==abs(d[1]):
                d = [d[0] // abs(d[0]) ,d[1] // abs(d[1])]

        r = bf[0]
        c = bf[1]
        # print(r, c)
        # print(dist)
        # print(d)
        for k in range(dist):
            r += d[0]
            c += d[1]

            if dist > 1 and not (r==cur[0] and c==cur[1]) and len(arr[r][c]) == 0:
                # print("d요기")
                answer = "NO"
                return
            if r==cur[0] and c==cur[1] and len(arr[r][c]):
                answer="NO"
                return

            if d in arr[r][c]:
                # 불가능 체크
                # print("요기??")
                answer = "NO"
                return
            arr[r][c].append(d)


N = int(input())
lst = list(map(int, input().split()))



arr = [[[] for _ in range(3)] for i in range(3)]
point_dict = {1: (0, 0), 2: (0, 1), 3: (0, 2), \
              4: (1, 0), 5: (1, 1), 6: (1, 2), \
              7: (2, 0), 8: (2, 1), 9: (2, 2)}

st = point_dict[lst[0]]
arr[st[0]][st[1]].append(-1)
if len(lst) <3:
    print("NO")
else:
    answer = "YES"
    check()
    print(answer)