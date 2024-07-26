word = input()
n = len(word)

lst = []
for i in range(0, n-2):
    for j in range(i+1, n-1):
       lst.append([i,j])

result = []
for l in lst:
    tmp = word[l[0]::-1]+word[l[1]:l[0]:-1]+word[:l[1]:-1]
    result.append(tmp)

result.sort()
print(result[0])