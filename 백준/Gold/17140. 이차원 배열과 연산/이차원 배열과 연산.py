"""
행 연산은 좀 쉬울듯 ? 열 연산 어쩌지 배열 회전할까


일단 행 연산부터 생각하자.
그 행에 있는 값을 key로 개수를 value로 딕셔너리로 만들기
 그 후 items로 k, v를 튜플로 lst에 넣고 정렬해서 (정렬할 땐 value우선)
 해당 행에 끼워넣기 !

 배열 크기 맞추기 max len을 찾아서 그만큼 0으로 채워준다



연산하고 행 / 열 길이 보고 행연산 열연산 결정. .!
arr[r][c]의 값이 k 가 되면 종료 혹은 time이 101 되면 종료

"""
R, C, K = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(3)]
time = 0
while 1:
    row_len = len(arr)
    col_len = len(arr[0])
    if time >100 or ( R-1 < row_len and C-1<col_len and arr[R-1][C-1] == K):
        break

    #행 / 열 크기 확인
    #배열 transpose
    if row_len < col_len:
        arr = list(map(list, zip(*arr)))

    #연산하자
    for i in range(max(row_len, col_len)):
        tmp_dict = {}
        for j in range(min(row_len, col_len)):
            if arr[i][j] == 0:
                continue
            tmp_dict[arr[i][j]] = tmp_dict.get(arr[i][j],0)+1

        lst = []
        for k, v in tmp_dict.items():
            lst.append([k,v])
        lst.sort(key=lambda x:(x[1], x[0]))
        arr[i] = []
        for a in lst:
            arr[i].extend(a)
        arr[i] = arr[i][:100]
    # 0채워주자
    mx = min(row_len, col_len)
    for i in range(len(arr)):
        mx = max(mx, len(arr[i]))
    for i in range(len(arr)):
        while len(arr[i]) < mx:
            arr[i].append(0)



    #transpose했었다면 되돌리자
    if row_len<col_len:
        # for i in range(len(arr)):
        #     print(arr[i])
        # print()
        arr = list(map(list, zip(*arr)))

    time += 1
    # for i in range(len(arr)):
    #     print(arr[i])
    # print()


print(time if time<=100 else -1)