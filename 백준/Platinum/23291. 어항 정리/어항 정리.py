"""

아예 구현 아이디어가 떠오르지 않는다 ;

일단 배열 오른쪽으로 90도 회전해서 반환하는 함수 만들어서
계속 써야할 것 같다

#어항쌓기 생각해보자
눕혀서는 어렵다
세로로 늘여서 수를 위로 쌓는걸 그 리스트에 append한다고 생각하자
l = 1 (쌓아갈 애의 길이)
for i in range(0, n)
    arr[i:i+l]를 시계방향으로 회전하기 (어차피 눕혀있던것도 시계방향으로 회전해서 똑같)
    그리고 남은 자리 n - i+l+1+1 이 지금 내 len(arr[i:i+l})보다 긴 지 확인
    길지 않다면 break


[5]
[2]
[3]
[14]
[9]
[2]
11
8
"""
def control():
    s = set() #좌표, 방향 (쌍방으로 넣기)
    #(행 열 d) 로 넣기
    tmp_arr = []
    for i in range(n):
        if not arr[i]:
            continue
        for j in range(len(arr[i])):
            for di, dj in (-1, 0), (0, 1), (1, 0), (0, -1):
                du = i+di
                dv = j+dj
                if du<0 or du>=n:
                    continue
                if len(arr[du]) <= dv or dv<0:
                    continue
                if (i, j, di, dj) in s:
                    continue
                s.add((i, j, di, dj))
                s.add((du, dv, -di, -dj))
                d = abs(arr[i][j] - arr[du][dv])//5
                if d==0:
                    continue
                if arr[i][j]<arr[du][dv]: #i, j가 작으면
                    tmp_arr.append((i, j, d))
                    tmp_arr.append((du, dv, -d))

                elif arr[i][j]>arr[du][dv]:
                    tmp_arr.append((i, j, -d))
                    tmp_arr.append((du, dv, d))

    for i, j, v in tmp_arr:
        arr[i][j] += v
def fly(st, k):

    left = arr[st:st+k//2]
    left = rotate(rotate(left))

    for i in range(k// 2):
        arr[st+k // 2 + i].extend(left[i])
        arr[st+i].clear()


def rotate(a):
    #배열 2차원으로 주어짐
    return [list(i) for i in list(zip(*a[::-1]))]


def pprint():
    for i in range(n):
        print(arr[i])

def set_line():
    idx = 0
    tmp = [[] for _ in range(n)]
    for i in range(n):
        l = len(arr[i])
        if l == 0:
            continue
        if l == 1:
            break
        for j in range(l):
            tmp[idx].append(arr[i][j])
            idx += 1
        arr[i].clear()
    for i in range(idx):
        arr[i].extend(tmp[i])

def find_gap_min():
    mx = 0
    mn = 10000

    for i in range(n):
        mx = max(mx, max(arr[i]))
        mn = min(mn, min(arr[i]))
    return mx-mn, mn



n, k = map(int, input().split())
arr = list(map(int, input().split()))
mx = max(arr)
#가장 적은 애들한테 +1
mn = min(arr)
gap = mx-mn
answer = 0


# 배열 세우기
arr = [[int(i)] for i in arr]
while gap >k:
    answer += 1
    for i in range(n):
        if not arr[i]:
            continue
        for j in range(len(arr[i])):
            if arr[i][j]==mn:
                arr[i][j]+=1
    #어항 쌓기
    """
    #어항쌓기 생각해보자
    눕혀서는 어렵다
    세로로 늘여서 수를 위로 쌓는걸 그 리스트에 append한다고 생각하자
    l = 1 (쌓아갈 애의 길이)
    
    가로 세로 길이 나눠서 생각해야할듯
    쌓아올린 높이가 다음엔 가로가 됨 
    for i in range(0, n)
        arr[i:i+l]를 시계방향으로 회전하기 (어차피 눕혀있던것도 시계방향으로 회전해서 똑같)
        그리고 남은 자리 n - i+l+1+1 이 지금 내 len(arr[i:i+l})보다 긴 지 확인
        길지 않다면 break
        
        
        """
    next_len = 1
    bottom_len = 1
    i = 0
    while i<n:
        #회전할 배열
        tmp = rotate(arr[i:i+bottom_len])
        next_len = len(arr[i])

        if i+bottom_len+next_len>n:
            break

        #회전한 배열 올릴 수 있으면
        for j in range(next_len):
            arr[i+bottom_len+j].extend(tmp[j])
        for j in range(bottom_len):
            arr[i+j].clear()

        i += bottom_len
        bottom_len = next_len
    #어항쌓기 완료



    #물고기 수 조절
    control()


    #물고기수조절 확인 완료


    #다시 일렬로 놓기
    set_line()


    #공중부양
    fly(0, n)

    fly(n//2, n//2)

    #물고기 수 조절
    control()

    #바닥에 일렬로 놓기
    set_line()
    gap, mn = find_gap_min()

print(answer)
