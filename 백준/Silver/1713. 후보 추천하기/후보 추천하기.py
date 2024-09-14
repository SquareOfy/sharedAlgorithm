"""
학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고,
그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는
그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.

"""
from collections import deque
n = int(input())
m = int(input())
picture = []
recommend = [0]*101
lst = list(map(int, input().split()))
for i in range(m):
    num = lst[i]
    flag = False
    for k in picture:
        if k[0] == num:
            flag = True
            break
    if not flag:
        if len(picture)<n:
            picture.append([num, i])
            recommend[num] +=1
        else:
            picture.sort(reverse = True, key = lambda x : (recommend[x[0]], x[1]))
            recommend[picture.pop()[0]] = 0
            picture.append([num, i])
            recommend[num]+=1
    else:
        recommend[num]+=1

picture.sort()
for i in range(len(picture)):
    print(picture[i][0], end=" ")