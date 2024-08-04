import sys
input = sys.stdin.readline
n, m = map(int, input().split())

#포켓몬 이름 - 번호 매칭은 dict 활용
#포켓몬 번호 - 이름 매칭을 찾기 위해서는 배열 활용 
d = dict()
pockets = [0]*(n+1)

for i in range(1, n+1):
    pockets[i] = input().rstrip()
    d[pockets[i]] = i

for i in range(m):
    q = input().rstrip()
    #질문 입력이 들어왔을 때, dict에 그 값이 있는지 먼저 확인
    if d.get(q) is not None:
        print(d[q])
       #없으면 숫자인 것이므로 배열에서 이름 찾아오기
    else:
        print(pockets[int(q)])
