def quick_sort(st, ed):
    if st >= ed:
        return
    
    pivot = st #pivot index 제일 왼쪽 값
    left = st + 1 #pivot 바로 오른쪽 idx가 left
    right = ed #제일 오른쪽이 right로 시작

    #left, right가 같아질 때까지 아래 반복
    while left < right: 
        #left와 right를 찾아서 둘의 자리를 바꿀 것 
        #자리를 바꾼 후의 left자리가 pivot보다 작고 right가 pivot보다 커야하므로
        #자리를 바꿀 대상을 찾기 위해 left값(배열값) pivot보다 커질 때,
        #right값이 pivot보다 작아지는 순간을 찾아 자리 바꿀 것
        
        #pivot 값보다 커지는 순간이 left로 잡기
        while left < ed and lst[left] <= lst[pivot]:
            left += 1
        #pivot 값보다 작아지는 순간이 right
        while right > st and lst[right] >= lst[pivot]:
            right -= 1
            
        #아직 둘이 같지 않다면 자리 바꾸기
        if left<right:
            lst[left], lst[right] = lst[right], lst[left]
    #left와 right를 자리 바꿔가며 pivot 값을 기준으로 작은값, 큰값 분류를 마쳤다면
    #pivot과 자리 바꾸기
    #pivot보다 작은 애들 중 가장 오른쪽에 있는 idx 값과 자리를 바꿔야 하므로 
    #left의 배열 값을 본다.
    #위의 while문에서 left를 +1하며, lst[left]값이 lst[pivot]보다 커질 수 있으므로
    #그럴 땐 left-1 자리에 있는 값과 pivot자리를 바꿔주고 
    #바뀐 pivot의 위치를 pivot변수에 기억한다.(다음 좌, 우 배열을 퀵정렬 하기 위해서)
    if lst[left] > lst[pivot]:
        lst[left - 1], lst[pivot] = lst[pivot], lst[left - 1]
        pivot = left - 1
    else:
        lst[left], lst[pivot] = lst[pivot], lst[left]
        pivot = left

    
    quick_sort(st, pivot - 1) #pivot을 기준으로 왼쪽 배열 정렬하기
    quick_sort(pivot + 1, ed) #pivot을 기준으로 오른쪽 배열 정렬하기


n = int(input())
lst = [int(input()) for _ in range(n)]
quick_sort(0, n - 1)
print(*lst, sep="\n")

