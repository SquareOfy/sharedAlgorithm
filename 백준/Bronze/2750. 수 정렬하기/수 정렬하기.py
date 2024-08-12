def merge_sort(left, right):
    #정렬할 배열이 한자리일 땐, answer 그 자리에 그 값 저장하고 정렬 끝
    if left >= right:
        answer[left] = lst[left]
        return
    mid = (left + right) // 2
    #가운데 기준으로 왼쪽 배열 병합정렬시키기
    merge_sort(left, mid)
    #오른쪽 배열 병합정렬 시키기
    merge_sort(mid + 1, right)
    #양 쪽 병합정렬 완료했으면 두 배열 비교해서 병합
    merge(left, right)



def merge(left, right):
    #가운데 값을 기준으로 배열 나누기
    mid = (left + right) // 2
    #가장 왼쪽값부터 작은 순으로 정답배열 채워갈 것
    idx = left

    
    i = left        #왼쪽 배열 index
    j = mid + 1     #오른쪽 배열 index

    #왼쪽 오른쪽 중 어느 한 쪽 다 소진할 때까지 answer배열로 작은 값 옮기기
    while i < mid + 1 and j <= right:
        
        #왼쪽 값이 더 작으면
        if lst[i] < lst[j]: 
            answer[idx] = lst[i]    #왼쪽 채워주고
            i += 1                  #왼쪽 index +1

        else:                       #오른쪽이 더 작으면 오른쪽 채우고
            answer[idx] = lst[j]
            j += 1                  #index + 1
        idx += 1                    #answer배열 가리키는 index +1
        
    #위 while문에서 왼쪽 혹은 오른쪽을 다 소진했다면 
    #어느 한 쪽은 아직 숫자가 남아있다.
    #따라서 어디가 남았냐에 따라 두 while문 중 하나만 동작하게 된다

    # 왼쪽배열을 가리키던 index가 아직 끝값에 도달 못한다면
    # 아래 조건문이 True가 되어 동작
    while i <= mid:
        answer[idx] = lst[i]    #i가 갈 수 있는 끝까지 가며 answer채우기
        i += 1
        idx += 1
        
    #반대로 오른쪽에 수가 남으면 아래가 동작
    while j <= right:
        answer[idx] = lst[j]
        j += 1
        idx += 1
    
    #answer을 다 채웠다면 다음 배열 정렬하러 갈텐데, 
    #위에서 계속 lst에 있는 값을 비교하며 answer을 채워나갔다.
    #따라서 지금까지 정렬된 answer값을 lst에 갱신해줘야
    #다음 정렬을 할 때, 지금까지 정렬한 결과값을 활용하여 정상적으로 동작할 수 있다.
    lst[left:right+1] = answer[left:right+1]

n = int(input())
lst = [int(input()) for _ in range(n)]
answer = [0] * n
merge_sort(0, n-1)
print(*answer, sep="\n")