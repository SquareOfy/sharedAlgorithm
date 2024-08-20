def find_place(s):
    for i in range(3):
        for j in range(10):
            if arr[i][j] == s:
                return [i, j]
    return [-1, -1]

def find_hand(u, v): #True 왼손 / False 오른손
    return v<left_range[u]

def get_distance(a, b):
    return abs(a[0]-b[0])+abs(a[1] - b[1])

arr = []
arr.append(list('qwertyuiop'))
arr.append(list('asdfghjkl.'))
arr.append(list('zxcvbnm...'))

left_range = [5,5,4]

l, r = input().split()
word = input()

left = find_place(l)
right = find_place(r)
answer = 0
for w in word:
    next = find_place(w)
    if find_hand(next[0], next[1]):
        answer += get_distance(left, next)
        left = next
    else:
        answer+= get_distance(right, next)
        right = next
    answer+=1
print(answer)