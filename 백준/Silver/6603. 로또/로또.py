def pick_num(idx, cnt):
    # print("idx : ", idx , "||||| cnt : ", cnt)
    # print(selected)
    if cnt == 6:
        print(*selected)
        return

    for i in range(idx, k):
        if k-i < 6-cnt:
            break
        if lst[i] not in visited and (cnt ==0 or (cnt > 0 and selected[cnt-1] < lst[i])):
            visited.add(lst[i])
            selected[cnt] = lst[i]
            pick_num(idx+1, cnt+1)
            visited.remove(lst[i])


while 1:
    k, *lst = map(int, input().split())
    lst = list(map(int, lst))
    if k ==0 :
        break
    visited = set()
    selected = [0] * 6
    pick_num(0, 0)
    print()
