word = input()

st = ord("A")

alph = [0]*((ord("Z"))-st+1)
for s in word:
    index_s = ord(s.upper()) -st
    alph[index_s] += 1

max = 0
answer = ""
for i in range(len(alph)):
    if(alph[i]>max):
        answer = chr(i+st)
        max = alph[i]
    elif(max!=0 and alph[i]==max):
        answer="?"

print(answer)