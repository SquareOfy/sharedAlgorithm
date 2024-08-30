#n!가지의 순열을 오름차순으로 정렬
#첫번째 숫자 1 : 다음 숫자 k가 주어지면 k번째 순열 출력
#두번째 숫자 2 : 임의의 순열 나타내는 수 n이 몇번째 수열인지 출력

"""
20! 너무 큰데요 ... 되나?

숫자의 규칙을 찾자
맨 앞자리
 1 : 1 ~ (n-1)!개
 2 : (n-1)!+1 ~ (n-1)!*2
 3
 4
 ..

 n -1: (n-1)!*(n-2)+1 ~ (n-1)!*(n-1)
 n : (n-1)! *(n-1)+1 ~ (n-1)!*n

 k가 주어지면 위 규칙 따라서 맨 앞자리 찾기
    마찬가지 규칙으로 다음 자리 찾기 반복 ... (재귀 ? )
"""
def find_seq(t, idx):

    if t == n+1:
        return
    #t번째에 들어갈 숫자를 찾자
    fac = factorial[n-t-1]
    for i in range(n-t):
        start = idx+fac*i
        if start<=k and start+fac >k:
            seq_num = find_nth_num(i)
            visited[seq_num] = 1
            answer.append(seq_num)
            find_seq(t+1, start)
            break

def find_nth_num(i):
    cnt =0
    for x in range(1, n+1):
        if not visited[x] and cnt==i:
            return x
        if not visited[x]:
            cnt +=1
def find_num_order(i):
    cnt =0
    for x in range(1, i):
        if not visited[x]:
            cnt+=1
    return cnt
n = int(input())
m, *lst = map(int, input().split())
factorial = [1, 1]
num = 1
visited = [0]*(n+1)
for i in range(2, n+1):
    num *= i
    factorial.append(num)
answer = []
if m==1:
    #수열 찾기
    k = lst[0]
    find_seq(0, 1)
else:
    l = 1
    for t in range(n):
        idx = find_num_order(lst[t]) #내가 지금 남은 수 중에 몇번째 작은 숫자인가
        l+= idx*(factorial[n-t-1])
        visited[lst[t]] = 1 #사용함 표기
    answer.append(l)
print(*answer)