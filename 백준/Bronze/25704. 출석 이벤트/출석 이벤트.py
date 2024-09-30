N = int(input())
P = int(input())
answer = P
if N >= 5:
    answer = max(0, P-500)
if N>=10:
    answer = min(answer, int(P*0.9))
if N>=15:
    answer = max(0, min(answer, P-2000))
if N>=20:
    answer = min(answer, int(P*0.75))

print(answer)