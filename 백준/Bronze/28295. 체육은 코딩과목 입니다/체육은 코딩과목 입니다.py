"""
상우좌하 (-1, 0), (0, 1), (1, 0), (0,-1)
우향우 +1 mod 4
뒤로돌아 +2 mod4
좌향좌 +3 mod4
"""
l = ['N', 'E', 'S', 'W']
d=0
for i in range(10):
    t = int(input())
    d += t
    d %= 4
print(l[d])