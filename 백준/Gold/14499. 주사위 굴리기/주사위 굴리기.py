"""
1523 문제이해 완료 및 구상시작
1530 아이디어 안떠오름. 다음 문제부터 ;;
16?? 다시 문제 돌아옴. 주사위 굴리는 것 구현 방법 고민,,
1642 주사위 굴리기 구현 방식 생각남
1713 주사위 구현했으나 top bottom표기 숫자와 방향 숫자 겹쳐서 결과 잘못나옴 디버깅함(1번테케 안맞음,, 다시)
1725 주사위 수 변하지 않는다는 문제 잘못읽은 문젭 ㅏㄹ견 ,,,
1726 백준도 제출하자 ..

=======================================
주사위 굴리기 어떻게 표현?
주사위 인덱스별로 top, bottom / 동서남북 기억
주사위 굴릴 때

이동방향  || bottom   top   동       서     남       북
동       || 서        동   bottom   top    남       북
서       || 동        서   top     bottom  남       북
남       || 북        남   동       서     bottom    up
북       || 남        북   동       서     top       bottom

이동방향에 따라 기존값이 위와 같이 변화
동서 북남 12 34
bottom 0 top 5로 표기하자
"""

def change_dice(l):
    #dice에서 현재 bottom인 곳을 dictionary에서 반대방향 뽑아서 바꾸기
    #top인 곳을 현재 방향으로 바꾸기
    #같은 방향인 곳을 bottom으로 바꾸기
    #반대 방향인 곳을 top으로 바꾸기
    opp = dic[l]

    ans_b = -1
    ans_t = -1
    for j in range(6):
        if dice_dir[j]==l:
            dice_dir[j] = 0
            ans_b = j
        elif dice_dir[j]==opp:
            dice_dir[j]=5
            ans_t = j
        elif dice_dir[j]==0:
            dice_dir[j]=opp
        elif dice_dir[j]==5:
            dice_dir[j]=l
    return ans_b, ans_t
dic = {1:2, 2:1, 3:4, 4:3} #동과 서 / 북과 남

dice = [0]*6
dice_dir = [i for i in range(6)]

n, m, x, y, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
lst = list(map(int, input().split()))
dir = (0, 1), (0, -1), (-1, 0), (1, 0) #동서북남 순
t = 5
for i in lst:
    next = i-1

    #방향
    d = dir[next]
    nr = x+d[0]
    nc = y+d[1]
    #벗어나면 이동 x
    if nr<0 or nc<0 or nr>=n or nc>=m:
        continue
    x = nr
    y = nc
    #아니라면 해당 방향대로 주사위 바닥을 옮겨보자
    b, t= change_dice(i)
    #b는 바닥의 index
    if arr[x][y]==0:
        arr[x][y] = dice[b]
    else:
        dice[b] = arr[x][y]
        arr[x][y] = 0

    print(dice[t])
