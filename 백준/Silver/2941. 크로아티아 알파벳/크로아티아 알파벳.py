import sys

input = sys.stdin.readline

croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

word = input().rstrip()
l = len(word)
answer = l

for alpha in croatia:
    if(alpha in word):
        m = len(alpha)
        cnt = 0
        for i in range(l):
            if(alpha==word[i:i+m]): 
                if(alpha=='z=' and i>0 and word[i-1]=='d'): 
                    continue
                cnt+=1

        answer -= m*cnt
        answer += cnt

print(answer)