"""
문제이해 30-35분
구상시작 35분 ~43분
구현완 3시 4분
테케 안맞음...  디버깅 시작
input 이 오름차순으로 들어오지 않아 합이 맞는지 확인하는 과정에서 리스트 불일치하는 문제 발생.
함수 :
    합 완성본 모으는 함수 ..

함수 : 뽑은 3개의 그림이 합이 되는지 판단하여 return T/F
    모양/색/배경 중 하나라도 모두 같은면 return True
    모양 하나라도 같은 것 있으면 return False
    색도 / 배경도

함수 : visited 탐색해서 False인게 있는지 여부 반환

9개 중 3개 뽑는 조합의 수 84
84개 중 합이 되는 경우만 모아 완성본 배열 만들기
이 완성본에 대한 visited 배열 만들기
합을 부르면 완성본 배열 탐색
=> 있으면서 not visited 이면 visited체크 +1 , 점수 +1
=> 없거나 visited 이면 점수 -1

결을 부르면 visited배열 중 1인게 있는지 확인 / 결 점수 flag 확인
둘다 없으면 점수 +3
else 점수 -1

"""

def make_hap_lst(level, idx, selected):
    if level == 3:
        if check(selected):
            hap.append(selected)
        return
    for i in range(idx, 7+level): #0개 - 6 1개 7
        make_hap_lst(level+1, i+1, selected+[arr[i]])



def check(selected):
     #모두 같거나 모두 달라야 한다

    for i in range(3):
        if selected[0][i]==selected[1][i]==selected[2][i]:
            #모두 같으면 문제 없다
            continue
        #모두 같지 않았는데 같은 게 있다? 합 불가
        if selected[0][i]==selected[1][i] or selected[1][i]==selected[2][i] or selected[0][i]==selected[2][i]:
            return False

    #selected안에 있는 세개의 그림이 합을 이루는지 판단하는 코드
    return True
def hap_score(a):
    for i in range(hap_cnt):
        h = hap[i]

        if h == a:
            if visited[i]:
                return -1
            visited[i] = 1
            return 1
    return -1
def gyul_score():
    for i in range(hap_cnt):
        if not visited[i]:
            return -1
    return 3
#
#input
arr = [list(input().split()) for i in range(9)]

n = int(input())
hap = []
make_hap_lst(0, 0, [])
hap_cnt = len(hap)
visited = [0] * hap_cnt
answer = 0
flag = False

for i in range(n):
    o, *order = input().split()
    order = list(map(int, order))
    order.sort()
    if o =='H': #합 부르면
        a = [arr[order[0]-1], arr[order[1]-1], arr[order[2]-1]]
        answer += hap_score(a)

    else:
        if flag:
            answer -= 1

        else:
            result = gyul_score()
            if result > 0:
                flag = True
            answer+=result

print(answer)