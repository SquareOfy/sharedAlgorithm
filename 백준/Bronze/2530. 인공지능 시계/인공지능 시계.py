import sys

input = sys.stdin.readline


h, m, s = map(int, input().split())
sec = int(input())

s+= sec
if(s>59):
    m+= s//60
    s%=60
    if(m>59):
        h += m//60
        m%=60
        if(h>23):
            h %=24

print(str(h)+' '+str(m)+' '+str(s))