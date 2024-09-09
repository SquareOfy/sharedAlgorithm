def is_possible():
    for i in range(5):
        if population[i] == 0:
            return False
    return True


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
population = [0] * 5

# x, y에 따라 d1, d2의 가능한 범위가 달라지므로
# x, y마다 d1, d2의 모든 경우를 고려해보자
# (20**2)**3

# d1, d2 고르고 나면 걔네로 1, 2, 3, 4 구역 정하고 5-(1,2,3,4)하기
answer = n * n * 100
popu = [[-1]*n for _ in range(n)]
for x in range(n):
    for y in range(n):
        for d1 in range(1, n):
            for d2 in range(1, n):

                if x+ d1 + d2 >= n :
                    continue

                if y-d1<0:
                    continue
                if y+d2>=n:
                    continue

                population = [0] * 5
                popu = [[-1] * n for _ in range(n)]


                # 이 조합으로 0, 1,  2, 3 계산
                # 잘못 설계함 ㅠㅠ
                st = y
                ed = y
                # print()
                # print("x, y, d1, d2")
                # print(x, y, d1, d2)
                # 5 먼저 채우고 나머지를 아래 기준으로 채워야함
                for r in range(x, x+d1+d2+1): #
                    #가로 시작 st 1씩 빼가다가 r이 x+d1 이후이면 더하기 시작
                    #가로 끝 ed 1씩 더해가다가 x+d2 이후이면 빼기 시작
                    for c in range(st, ed+1):
                        popu[r][c] = 4
                        population[4]+= arr[r][c]

                    if r<x+d1:
                        st -= 1
                    else:
                        st += 1

                    if r<x+d2:
                        ed += 1
                    else:
                        ed -= 1


                for r in range(n):
                    for c in range(n):
                        if popu[r][c] == 4:
                            continue
                        if r < x + d1 and c <= y:
                            population[0] += arr[r][c]
                            popu[r][c] = 0
                        elif r <= x + d2 and y < c < n:
                            population[1] += arr[r][c]
                            popu[r][c] = 1
                        elif x + d1 <= r < n and c < y - d1 + d2:
                            population[2] += arr[r][c]
                            popu[r][c] = 2
                        elif x + d2 < r < n and y - d1 + d2 <= c < n:
                            population[3] += arr[r][c]
                            popu[r][c] = 3
                if is_possible():
                    answer = min(max(population) - min(population), answer)


                # for i in range(n):
                #     print(popu[i])
                # print(population)
                # print(max(population) - min(population))
                # print()
print(answer)